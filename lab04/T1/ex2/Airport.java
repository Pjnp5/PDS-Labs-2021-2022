package lab3.ex2;

import java.util.*;

public class Airport {
    private ArrayList<Flight> flights = new ArrayList<>();

    public Airport(){};

    // Métodos para adicionar voos ao ArrayList flights
    public void addFlight(String code, String lugaresTuristicos){
        String[] dados = lugaresTuristicos.split("x");
        flights.add(new Flight(code, new Plane(Integer.parseInt(dados[0]), Integer.parseInt(dados[1]))));
    }

    public void addFlight(String code, String lugaresExec, String lugaresTuristicos){
        String[] dadosTour = lugaresTuristicos.split("x");
        String[] dadosExec= lugaresExec.split("x");
        flights.add(new Flight(code,  new Plane(Integer.parseInt(dadosExec[0]), Integer.parseInt(dadosExec[1]), Integer.parseInt(dadosTour[0]), Integer.parseInt(dadosTour[1]))));
    }

    // Método que vai processar uma reserva relacionada com o voo de código codFlight
    public Reservation makeReservation(String codeFlight, Character code, int seats){
        // Percorre o array de voos registados
        for(Flight f:flights){
            if(f.getFlightCode().equals(codeFlight)){
                Reservation r = new Reservation(code, seats);
                if(f.addReservation(r)){
                    return r;
                }
            }
        }

        return null;
    }

    // Método que vai retornar um Voo guardado no ArrayList flights
    public Flight getFlight(String codeFlight){
        for(Flight f:flights){
            if(f.getFlightCode().equals(codeFlight)){
                return f;
            }
        }

        return null;
    }

    // Método que vai cancelar uma reserva
    public void cancelReservation(String code){
        String info[] = code.split(":");
        Flight f = this.getFlight(info[0]);
        Reservation r = f.getReservation(Integer.parseInt(info[1]));

        if (r != null){
            f.cancelReservation(r);
        }else{
            System.out.println("ERROR: Reservation doesn't exist!");
        }
    }

}
