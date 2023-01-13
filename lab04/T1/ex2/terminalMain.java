package lab3.ex2;

import java.io.*;
import java.util.*;

public class terminalMain {
    private static Airport montijo = new Airport();                                     // Gestor das operações do Aeroporto

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean cont = true;

        // Menu
        do{
            System.out.println("Escolha uma opção: (H para ajuda)");
            String[] command = sc.nextLine().split(" ");

            switch(command[0]){
                case "H":
                    getHelp();
                    break;
                case "I":
                    readFlightData(command[1]);
                    break;
                case "M":
                    Flight f = montijo.getFlight((command[1]));
                    if(f != null){
                        f.printMap();
                    }else{
                        System.out.println("ERROR: Flight doesn't exist!");
                    };
                    break;
                case "F":
                    if(command.length == 3){
                        montijo.addFlight(command[1], command[2]);
                        System.out.println("Voo criado:\n");
                        System.out.println(montijo.getFlight(command[1]));
                    }else if(command.length == 4){
                        montijo.addFlight(command[1], command[2], command[3]);
                        System.out.println("Voo criado:\n");
                        System.out.println(montijo.getFlight(command[1]));
                    }else{
                        System.out.println("ERROR: Input should be F <flight_code num_seats_executive num_seats_tourist> ");
                    }
                    break;
                case "R":
                    if(command.length == 4){
                        Reservation r = montijo.makeReservation(command[1], command[2].charAt(0), Integer.parseInt(command[3]));

                        if(r!= null){
                            System.out.println("Reservation created:");
                            System.out.println(r);
                        }else{
                            System.out.println("ERROR: The associated flight doesn't exist!");
                        }

                    }else{
                        System.out.println("ERROR: Input should be R <flight_code class number_seats> ");
                    }
                    break;
                case "C":
                    if(command.length == 2){
                        montijo.cancelReservation(command[1]);
                    }else{
                        System.out.println("ERROR: Input should be C <reservation_code> ");
                    }
                    break;
                case "Q":
                    cont = false;
                    break;
                default:
                    System.out.println("ERROR: Invalid input");
                    getHelp();
            }
        }while(cont);
    }

    // Função que apresenta as opções do menu
    public static void getHelp(){
        String sb = "Available options:\n" +
                "I <filename> -> Read an input file with information about a flight\n" +
                "M <flight_code> -> Show the reservation map of a flight\n" +
                "F <flight_code num_seats_executive num_seats_tourist> -> Add a new flight\n" +
                "R <flight_code class number_seats> -> Make a new reservation\n" +
                "C <reservation_code> -> Cancel a reservation\n" +
                "Q -> Quit\n";
        System.out.println(sb);
    }

    // Função que vai ler o ficheiro de input na opção -i
    public static void readFlightData(String path){
        File inputFile = new File(path);

        try(Scanner fin = new Scanner(inputFile)){

            String[] flightInfo = fin.nextLine().split(" ");

            // Se ficheiro não começar por >
            if(flightInfo[0].charAt(0) != '>'){
                System.err.println("ERROR: Wrong file format");
                return;
            }

            String flightCode = flightInfo[0].substring(1);

            // Adição do voo à lista de voos registados pelo gestor
            if(flightInfo.length == 2){
                montijo.addFlight(flightCode, flightInfo[1]);
            }else if(flightInfo.length == 3){
                montijo.addFlight(flightCode, flightInfo[1], flightInfo[2]);
            }else{
                System.err.println("ERROR: Wrong file format");
                return;
            }

            // Reservas
            while(fin.hasNextLine()){
                flightInfo = fin.nextLine().split(" ");
                montijo.makeReservation(flightCode, flightInfo[0].charAt(0), Integer.parseInt(flightInfo[1]));
            }

            // Printa no terminal a informação relacionada com o voo
            System.out.println(montijo.getFlight(flightCode));
        } catch (FileNotFoundException e) {
            System.err.println("ERROR: File not found.");
            e.printStackTrace();
        }
    }
}
