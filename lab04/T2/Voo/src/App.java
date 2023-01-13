import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.util.HashMap;

public class App {

    //The main functions handles everything relating to the user input and the different options.
    public static void main(String[] args) throws Exception {

        //A dictionary so that we can find a flight by its ID.
        HashMap<String, Flight> flights = new HashMap<String, Flight>();

        //Read user input continiously.
        Scanner scanner = new Scanner(System.in);
        while(true){

            //Gets the user input
            System.out.println("Escolha uma opção: (H para ajuda)");
            String command = scanner.nextLine();

            //Help options, prints out all the commands and parameters.
            if(command.equals("H")){

                System.out.println("H: apresenta as opções do menu.");
                System.out.println("\nI filename: Lê um ficheiro de texto contento informação sobre um voo. A primeira linha do ficheiro deve começar com o caracter '>' e indicar o código de voo, o número de filas e lugares por fila em classe executiva (caso exista) e o número de filas e lugares por fila em classe turística. As linhas seguintes, caso existam, contêm reservas já efetuadas, no formato classe, número de lugares, como se vê nos exemplos.");
                System.out.println("\nM flight_code: exibe o mapa das reservas de um voo, conforme mostra o exemplo. Os lugares reservados são identificados pelo número sequencial da reserva; os lugares livres são identificados pelo número 0.");
                System.out.println("\nF light_code num_seats_executive num_seats_tourist: acrescenta um novo voo, com código, lugares em executiva (p.ex. 4x3, representando 4 filas com 3 lugares por fila), e lugares em turística. Os lugares em classe executiva são opcionais, podendo existir apenas lugares em turística.");
                System.out.println("\nR Flight_code class number_seats: acrescenta uma nova reserva a um voo, com indicação do código do voo, da classe (T / E), e do número de lugares. O programa deve verificar se há lugares disponíveis na classe pretendida. Caso a reserva seja efetuada deve ser apresentado no ecrã o código da reserva no formato flight_code:sequential_reservation_number e os lugares atribuídos.");
                System.out.println("\nC Reservation_code: cancela uma reserva. O código de reserva tem o formato flight_code:sequential_reservation_number.");
                System.out.println("\nQ: Termina o programa.\n");
                continue;
            }

            //Reads a flight info from a file and creates it.
            if(command.charAt(0) == 'I'){
                //Parse the txt file
                Flight flight = CreateFlightFromFile(command.substring(2));

                //If the text file was valid, then add the flight to the dictionary.
                if(flight != null)
                    flights.put(flight.GetCode(), flight);

                continue;
            }

            //Prints ou the map of the airplane
            if(command.charAt(0) == 'M'){
                try {
                    //Creates the file with the given code
                    String[] terms = command.split(" ");
                    Flight flight = flights.get(terms[1]);

                    //Prints the map
                    flight.PrintMap();
                } catch (Exception e) {
                    System.out.println("Argumentos inválidos.");
                }

                continue;
            }

            //Adds a new flight
            if(command.charAt(0) == 'F'){

                //Everything inside a try catch so that we filter out bad input
                try{

                    //Split the command into terms
                    String[] terms = command.split(" ");

                    //Creates the file with the given ID
                    Flight flight = new Flight(terms[1]);
        
                    //If there is exactly three terms, then there is no executive class.
                    if(terms.length == 3){
                        //Transform the string into ints
                        String[] XandY = terms[2].toUpperCase().split("X");
                        int filTourist = Integer.parseInt(XandY[0]);
                        int colTourist = Integer.parseInt(XandY[1]);   
                        
                        //And creates the plane with the given seats
                        flight.CreatePlane(filTourist, colTourist);
                    }
                    //If else, then there is an exectuvei class
                    else{
                        //Transform the string into ints
                        String[] XandY = terms[2].toUpperCase().split("X");
                        int filExec = Integer.parseInt(XandY[0]);
                        int colExec = Integer.parseInt(XandY[1]);   

                        XandY = terms[3].toUpperCase().split("X");
                        int filTourist = Integer.parseInt(XandY[0]);
                        int colTourist = Integer.parseInt(XandY[1]);   

                        //And creates the plane with the given seats
                        flight.CreatePlane(filTourist, colTourist, filExec, colExec);
                    }
                }catch(Exception e) {
                    System.out.println("Argumentos inválidos.");
                }
                continue;
            }

            //Adds a new reservations to an existing flight
            if(command.charAt(0) == 'R'){
                //Everything inside a try catch so that we filter out bad input
                try {
                    //Split the command into terms
                    String[] terms = command.split(" ");

                    //Parses the info; The flight ID, and type (T or E) and the number of seats.
                    String ID = terms[1];
                    boolean type = terms[2].equals("T");
                    int numSeats = Integer.parseInt(terms[3]);

                    //Tries to get the flight with the ID from the dict. If it doesn't exist, an exception will be thrown later.
                    Flight flight = flights.get(ID);

                    //Attempts to make a reservation. If the reservation was a success...
                    if(flight.MakeReservation(type, numSeats)){
                        //Prints out the flight ID and the reservation number
                        System.out.print(ID+":"+flight.GetCurrentReservationNumber()+" = ");

                        //Gets every seat from the reservation...
                        List<Seat> seats = flight.GetSeatsFromReservation(flight.GetCurrentReservationNumber());
                        //Goes through each one and prints it.
                        for (int i = 0; i < seats.size(); i++) {
                            System.out.print(seats.get(i).toString());

                            if(i != seats.size() - 1)
                                System.out.print(" | ");
                        }
                        System.out.println();
                    }

                } catch (Exception e) {
                    System.out.println("Argumentos inválidos.");
                }
                continue;
            }

            //Remove a reservation.
            if(command.charAt(0) == 'C'){
                try {
                    //Split and parses the command
                    String[] terms = command.substring(2).split(":");
                    String code = terms[0];
                    int reservationNum = Integer.parseInt(terms[1]);

                    //Gets the flight from the dict.
                    Flight flight = flights.get(code);

                    //Deletes the reservation.
                    flight.DeleteReservation(reservationNum);
                    System.out.println("Reserva cancelada.");

                    continue;
                } catch (Exception e) {
                    System.out.println("Argumentos inválidos.");
                }

            }

            //Terminates the program
            if(command.equals("Q")){
                break;
            }
            
        }
    }

    //Class for holding the .txt file data as an object.
    static class FileData{
        public String ID;
        public int filTourist, colTourist;
        public int filExec, colExec;

        public List<String> reservations = new ArrayList<String>();

    };

    //Creates a flight from a text file.
    private static Flight CreateFlightFromFile(String path){

        //Parses the text data and gets a FileData object.
        FileData data = ReadFile(path);
        if(data == null)
            return null;

        //Creates the file from the ID
        Flight flight = new Flight(data.ID);

        //Creates the plane...
        if(data.filExec != 0 && data.colExec != 0){
            //With executive class
            flight.CreatePlane(data.filTourist, data.colTourist, data.filExec, data.colExec);
        }
        else{
            //Without executive class
            flight.CreatePlane(data.filTourist, data.colTourist);
        }

        //Parses the reservation data and makes it.
        for (String reserv : data.reservations) {
            Boolean type = reserv.charAt(0) == 'T';
            int numPassangers = Integer.parseInt(reserv.charAt(2) + "");
            flight.MakeReservation(type, numPassangers);
        }

        return flight;
    }

    //Parses the .txt into a FileData object. Throws exception if the file is invalid.
    private static FileData ReadFile(String filePath){

        try{    
            FileData data = new FileData();
            File file = new File(filePath);

            // Throws error if the file couldn't not be read or found.
            if (!file.canRead()) {
                System.out.println("File '"+filePath+"' cannot be read or found.");
                return null;
            }

            Scanner myReader = new Scanner(file);

            // Reads the file line by line
            boolean firstLine = true;
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();

                if(firstLine){
                    firstLine = false;
                    
                    if(line.charAt(0) != '>')
                    {
                        System.out.println("File '"+filePath+"' is invalid.");
                        return null;
                    }
                    line = line.substring(1);

                    String[] terms = line.split(" ");


                    if(terms.length < 2 || terms.length > 3)
                    {
                        System.out.println("File '"+filePath+"' is invalid.");
                        return null;
                    }

                    data.ID = terms[0];

                    if(!data.ID.matches("^[a-zA-Z0-9]*$")){
                        System.out.println("File '"+filePath+"' is invalid.");
                        return null;     
                    }
                    
                    if(terms.length == 2){
                        String[] XandY = terms[1].split("x");
                        data.filTourist = Integer.parseInt(XandY[0]);
                        data.colTourist = Integer.parseInt(XandY[1]);
                    }

                    if(terms.length > 2){
                        String[] XandY = terms[1].split("x");
                        data.filExec = Integer.parseInt(XandY[0]);
                        data.colExec = Integer.parseInt(XandY[1]);
                    }

                    if(terms.length >= 3){
                        String[] XandY = terms[2].split("x");
                        data.filTourist = Integer.parseInt(XandY[0]);
                        data.colTourist = Integer.parseInt(XandY[1]);
                    }
                }else{

                    data.reservations.add(line);
                }
            }
            myReader.close();
            return data;
        }
        // Cathes an execption with the scanner if something is wrong
        catch (FileNotFoundException e) {
            System.out.println("File '"+filePath+"' is invalid.");
            e.printStackTrace();
            return null;
        }
    }
}
