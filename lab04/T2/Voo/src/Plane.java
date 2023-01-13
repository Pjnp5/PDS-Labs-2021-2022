import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Plane {

    //Bidimensional array containing the tourist seats data. Zero means empty, a non-zero number means seat taken, and the reservation it belongs to it's the number itself.
    private int[][]touristSeats;
    //We also store the dimensions of the tourist seats.
    private int filTourist, colTourist;
    private int numTourists; //Simply the rows * the columns

    //Same but with executive class.
    private int[][]executiveSeats;
    private int filExec, colExec;
    private int numExecutives;


    //Counter variable to current reservation.
    private int reservationCount = 0;

    //Dictionary so it's easier to locate which seats are associated with what reservation. Useful for deletion.
    HashMap<Integer, List<Seat>> touristReservations = new HashMap<Integer, List<Seat>>();
    HashMap<Integer, List<Seat>> execReservations = new HashMap<Integer, List<Seat>>();

    //Creates a plane with just tourist class.
    public Plane(int fil, int col){
        this.touristSeats = new int[fil][col];

        this.filTourist = fil;
        this.colTourist = col;
        this.numTourists = fil * col;
    }

    //Creates a plane with tourist class and executive class.
    public Plane(int filTourist, int colTourist, int filExecutive, int colExecutive){
        this.touristSeats = new int[filTourist][colTourist];
        this.executiveSeats = new int[filExecutive][colExecutive];

        this.numTourists = filTourist * colTourist;
        this.filTourist = filTourist;
        this.colTourist = colTourist;

        this.numExecutives = filExecutive * colExecutive;
        this.filExec = filExecutive;
        this.colExec = colExecutive;
    }

    //Attempts to make a reservation. Returns weather it was succesful or not.
    public boolean MakeReservation(boolean type, int numSeats){

        //If it's a tourist reservation...
        if(type){
            //If the are no more spaces left, then don't do it.
            numTourists -= numSeats;
            if(numTourists <= 0)
            {
                System.out.println("Não foi possível obter lugares para a reserva: T "+numSeats);
                return false;
            }
            SelectReservation(touristSeats, touristReservations,filTourist, colTourist, numSeats);
        }
        //If it's an executive reservation...
        else{
            //If there is no executive class, print it.
            if(filExec == 0 && colExec == 0)
                System.out.println("Classe executiva não disponível neste voo.");

            //If the are no more spaces left, then don't do it.
            numExecutives -= numSeats;
            if(numExecutives <= 0){
                System.out.println("Não foi possível obter lugares para a reserva: E "+numSeats);
                return false;
            }

            //Select reservation spots
            SelectReservation(executiveSeats, execReservations, filExec, colExec, numSeats);
        }

        return true;
    }

    //Select the seats in the reservation in accordance to the guidelines.
    private void SelectReservation(int[][]seats, HashMap<Integer, List<Seat>> reservations, int fil, int col, int numPassangers){
                
        //Increases the reservation count over.
        reservationCount++;

        //And creates the entries in the reservations dictionary.
        touristReservations.put(reservationCount, new ArrayList<Seat>() );
        execReservations.put(reservationCount, new ArrayList<Seat>() );

        int seatsLeft = numPassangers;
        int startSearchFil = 0; //Determines in which row to start looking for empty seats

        //Firstly, try to find an empty row
        for (int y = 0; y < fil; y++) {
            boolean isFree = true;
            for (int x = 0; x < col; x++) {
                //If at least one of them is not empty, then the row is not empty.
                if(seats[y][x] != 0)
                {
                    isFree = false;
                    break;
                }
            }
            //If there is an empty row...
            if(isFree){
                //Sets as many sets as possible in that row
                for (int i = 0; i < col; i++) {
                    //If there are no more seats to take, then stop here.
                    if(seatsLeft == 0)
                        return;
                    //Change from empty to the reservation number in the matrix
                    seats[y][i] = reservationCount;
                    //Adds position to the reservation dict
                    reservations.get(reservationCount).add(new Seat(y,i));
                    //One less seat to go
                    seatsLeft--;
                }
                //Try to fil the remaining seats in the next row over
                startSearchFil = y + 1;
            }
        }

        //If did not find empty row OR there are still seats to add...
        for (int y = startSearchFil; y < fil; y++) {
            for (int x = 0; x < col; x++) {
                //If it's empty
                if(seats[y][x] == 0){
                    //Do the same proccess of taking a set
                    seats[y][x] = reservationCount;
                    reservations.get(reservationCount).add(new Seat(y,x));
                    seatsLeft--;
                    //Stop when there's no seats left.
                    if(seatsLeft == 0)
                        return;
                }
            }
        }
    }
    
    //Method for deleting a reservation
    public void DeleteReservation(int reservationNum) {
        //Flags every tourist seat in the reservation as empty...
        for (Seat seat : touristReservations.get(reservationNum)) {
            touristSeats[seat.Fila()][seat.Coluna()] = 0;
        }
        //Removes the entry from the dict.
        touristReservations.remove(reservationNum);

        //Flags every executive seat in the reservation as empty...
        for (Seat seat : execReservations.get(reservationNum)) {
            executiveSeats[seat.Fila()][seat.Coluna()] = 0;
        }
        //Removes the entry from the dict.
        execReservations.remove(reservationNum);
    }


    @Override
    //Returns a string of the plane as a map. Like specified in the guidelines.
    public String toString() {

        String hRuler = "";
        int hLength = filExec+filTourist;
        for (int i = 1; i < hLength+1; i++) {
            hRuler += "\t"+i;      
        }
        String vRuler = "";
        int vLength = Math.max(colExec, colTourist);
        for (int i = 0; i < vLength; i++) {
            vRuler +=(char)(i+65)+ "\n";
        }

        String execBlock = "";
        for (int y = 0; y < colExec; y++) {
            for (int x = 0; x < filExec; x++) {
                execBlock += executiveSeats[x][y];

                if(x != filExec - 1)
                    execBlock += "\t";
            }   
            execBlock += "\n";
        }

        String touristBlock = "";
        for (int y = 0; y < colTourist; y++) {
            if(colExec > 0 && y >= colExec)
                for (int i = 0; i < colExec + 1; i++) {
                    touristBlock +="\t";
                }
            for (int x = 0; x < filTourist; x++) {
                touristBlock += touristSeats[x][y];

                if(x != filTourist - 1)
                    touristBlock += "\t";
            }   
            touristBlock += "\n";
        }

        String combString = hRuler+"\n";

        String[] execLines = execBlock.split("\n");
        String[] touristLines = touristBlock.split("\n");
        String[] ruleLines = vRuler.split("\n");
        for (int i = 0; i < vLength; i++) {
            combString += ruleLines[i];
            combString += "\t";     

            if(i < colExec)
                combString += execLines[i] + "\t";

            if(i < colTourist)
                combString += touristLines[i];
            combString += "\n";     
        }

        return combString;
    }

    //Getters
    public int GetCurrentReservationNumber(){
        return this.reservationCount;
    }
    public List<Seat> GetSeatsFromReservation(int number){
        return touristReservations.get(number);
    }
}