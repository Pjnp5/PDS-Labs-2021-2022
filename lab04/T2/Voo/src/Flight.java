import java.util.List;

public class Flight {

    //The flight ID
    private String ID;
    //Each flight must have a plane
    private Plane plane;

    //Creates a flight. Must have a code.
    public Flight(String code){
        this.ID = code;
    }

    //All the other methods are essantially abstractions for the plane object.
    public void CreatePlane(int fil, int col){
        this.plane = new Plane(fil, col);

        System.out.println(String.format("Código de voo %s. Lugares disponíveis: %d lugares em classe Turística.", this.ID, fil*col));
    }

    public void CreatePlane(int filTourist, int colTourist, int filExecutive, int colExecutive){
        this.plane = new Plane(filTourist, colTourist, filExecutive, colExecutive);

        System.out.println(String.format("Código de voo %s. Lugares disponíveis: %d lugares em classe Executiva; %d lugares em classe Turística.", this.ID, filTourist*colTourist, filExecutive*colExecutive));
    }

    public boolean MakeReservation(Boolean type, int numSeats){
        return this.plane.MakeReservation(type, numSeats);
    }

    public int GetCurrentReservationNumber(){
        return this.plane.GetCurrentReservationNumber();
    }

    public List<Seat> GetSeatsFromReservation(int number){
        return this.plane.GetSeatsFromReservation(number);
    }

    public void DeleteReservation(int reservationNum){
        this.plane.DeleteReservation(reservationNum);
    }

    public String GetCode(){
        return this.ID;
    }

    @Override
    public String toString() {
        return this.ID;
    }

    public void PrintMap() {
        System.out.println(plane.toString());
    }
}