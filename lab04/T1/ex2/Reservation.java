package lab3.ex2;

import java.util.Objects;

public class Reservation {
    public static int sequentialReservationNumber = 0;
    private final int reservationId;
    private String reservationCode;
    private char flightClass;
    private int passengerNumber;

    // Construtores
    public Reservation(char flightClass, int passengerNumber) {
        this.reservationId = ++Reservation.sequentialReservationNumber;
        this.flightClass = flightClass;
        this.passengerNumber = passengerNumber;
    }

    // Setters e Getters
    public int getReservationId() {
        return reservationId;
    }

    public char getFlightClass() {
        return flightClass;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public String getReservationCode() {
        return reservationCode;
    }

    public void setReservationCode(String reservationCode) {
        this.reservationCode = reservationCode;
    }

    // Overrides

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return reservationId == that.reservationId && flightClass == that.flightClass && passengerNumber == that.passengerNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationId, flightClass, passengerNumber);
    }

    @Override
    public String toString() {
        return String.format("%d: %s %d", this.reservationId, this.flightClass, this.passengerNumber);
    }
}


