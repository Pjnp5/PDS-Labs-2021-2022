package ex3;


public class Arrivel implements Command{
    private RailwayStationMediator mediator;

    public Arrivel(RailwayStationMediator mediator) {
        this.mediator = mediator;
    }

    public void Arriving(){
        System.out.println("Almost Arriving");
    }

    public void arrive(){
        if(mediator.canArrive()){
            System.out.println("Successfully Arrived");
            mediator.setArrivelStatus(true);
        }
        else{

            System.out.println("Waiting to arrive");
        }


    }


    
}
