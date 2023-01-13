package lab3.ex2;

import java.util.*;

public class Flight {
    private String flightCode;
    private Plane plane;
    private ArrayList< ArrayList<Integer> > touristicMap = new ArrayList<>();
    private ArrayList< ArrayList<Integer> > execMap = new ArrayList<>();
    private ArrayList<Reservation> flightReservations = new ArrayList<>();
    private int avlTouristic, avlExec;

    // Construtores
    public Flight(String flightCode, Plane plane) {
        this.flightCode = flightCode;
        this.plane = plane;

        // Vai buscar o número de lugares disponiveis no Plane
        this.avlExec = plane.getExecutiveSeats();
        this.avlTouristic = plane.getTouristicSeats();

        // Criação das estruturas de dados associadas com as classes T e E
        for(int i = 0; i < plane.getTouristicRows(); i++){
            touristicMap.add((new ArrayList<Integer>()));
        }

        for(int i = 0; i < plane.getExecRows(); i++){
            execMap.add((new ArrayList<Integer>()));
        }
    }

    // Setters e Getters
    public String getFlightCode() {
        return flightCode;
    }

    // Retorna uma reserva do array flightReservations
    public Reservation getReservation(int id){
        for(Reservation r:flightReservations){
            if (r.getReservationId() == id){
                return r;
            }
        }

        return null;
    }

    // Cancela uma reserva
    public void cancelReservation(Reservation r){
        flightReservations.remove(r);
    }

    // Outros Métodos
    // Método que adiciona uma Reserva ao ArrayList flightReservations
    public boolean addReservation(Reservation r){
        if(checkReservation(r)){                // Se a reserva é válida
            if(r.getFlightClass() == 'E'){
                seatPassengers(r, this.execMap, this.plane.getEsRow());
                r.setReservationCode(this.flightCode + ":" + r.getReservationId());
                flightReservations.add(r);
                return true;
            }else{                              // Se não for E é T, já que passou no checkReservation
                seatPassengers(r, this.touristicMap, this.plane.getTsRow());
                r.setReservationCode(this.flightCode + ":" + r.getReservationId());
                flightReservations.add(r);
                return true;
            }
        }else{                                  // Reserva não é válida
            Reservation.sequentialReservationNumber--;
            System.out.format("Não foi possível obter lugares para a reserva: %s %d\n",r.getFlightClass(),r.getPassengerNumber());
            return false;
        }
    }

    // Printa o Mapa de Reservas do avião
    public void printMap(){
        String msg = "   ";
        int line = Math.max(plane.getEsRow(), plane.getTsRow());
        int col = plane.getTotalRows();

        // Preencher lugares livres dos mapas com 0's
        for(ArrayList<Integer> fila:this.execMap){
            while(fila.size() < plane.getEsRow()){
                fila.add(0);
            }
        }

        for(ArrayList<Integer> fila:this.touristicMap){
            while(fila.size() < plane.getTsRow()){
                fila.add(0);
            }
        }

        // Printar Mapa
        for(int i = 1; i <= col; i++){
            msg += String.format("%2d ", i);
        }

        msg += "\n";

        for(int i = 0; i < line; i++){
            msg += String.format("%2s ", String.valueOf((char)(65 + i)));

            if(i < plane.getEsRow()){
                for(ArrayList<Integer> fila:this.execMap){
                    msg += String.format("%2d ", fila.get(i));
                }
            }else{
                for(int j = 0; j < plane.getExecRows(); j++ ){
                    msg += String.format("   ");
                }
            }

            for(ArrayList<Integer> fila:this.touristicMap){
                msg += String.format("%2d ", fila.get(i));
            }

            msg += "\n";
        }

        System.out.println(msg);
    }

    // Métodos privados auxiliares

    // Verifica se classe de Reserva é válida e se existem lugares livres na classe correspondente
    private boolean checkReservation(Reservation r){
        if(r.getFlightClass() == 'E'){
            // Nº de Lugares livres
            return this.avlExec >= r.getPassengerNumber();
        }else if(r.getFlightClass() == 'T'){
            // Nº de Lugares livres
            return this.avlTouristic >= r.getPassengerNumber();
        }else{
            System.err.println("ERROR: Not a valid Reservation Class!");
            return false;
        }
    }

    // Função que vai fazer as verificações e atribuições de lugares aos passageiros
    private void seatPassengers(Reservation r, ArrayList< ArrayList<Integer>> map, int seatsPerRow){
        int passNotSeated = r.getPassengerNumber();                         // Nº de passageiros por sentar

        // Adicionar Passageiros numa Fila Vazia
        for(ArrayList<Integer> fila:map){
            if(fila.size() == 0){
                // Fila Vazia

                if(passNotSeated <= seatsPerRow){
                    // Se o nº de passageiros da Reserva for menor que o nº de lugares por fila
                    int prego = passNotSeated;
                    for(int i = 0; i < prego; i++){
                        fila.add(r.getReservationId());
                        passNotSeated--;

                        if(r.getFlightClass() == 'E'){
                            this.avlExec -= 1;
                        }else{
                            this.avlTouristic -= 1;
                        }
                    }
                    break;
                }else{
                    for(int i = 0; i < seatsPerRow; i++){
                        // Se o nº de passageiros da Reserva for maior que o nº de lugares por fila
                        fila.add(r.getReservationId());
                        passNotSeated--;

                        if(r.getFlightClass() == 'E'){
                            this.avlExec -= 1;
                        }else{
                            this.avlTouristic -= 1;
                        }
                    }
                }
            }
        }

        // Adicionar Passageiros em qualquer lugar vazio
        while(passNotSeated > 0){
            // System.out.println("Cheguei 2\n");
            for(ArrayList<Integer> fila:map){
                if(fila.size() < seatsPerRow){
                    fila.add(r.getReservationId());
                    passNotSeated--;

                    if(r.getFlightClass() == 'E'){
                        this.avlExec -= 1;
                    }else{
                        this.avlTouristic -= 1;
                    }
                }
            }
        }
    }


    // Overrides

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return avlTouristic == flight.avlTouristic && avlExec == flight.avlExec && flightCode.equals(flight.flightCode) && plane.equals(flight.plane) && Objects.equals(touristicMap, flight.touristicMap) && Objects.equals(execMap, flight.execMap) && Objects.equals(flightReservations, flight.flightReservations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightCode, plane, avlTouristic, avlExec);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Código de voo ").append(this.flightCode);
        sb.append("\nLugares disponíveis: ").append(this.plane.getExecutiveSeats()).append(" lugares em Classe Executiva; ");
        sb.append(this.plane.getTouristicSeats()).append(" lugares em Classe Turística.\n");

        return sb.toString();
    }
}
