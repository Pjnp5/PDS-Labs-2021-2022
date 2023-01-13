package ex3;


public class TrainLine implements Command{
    private RailwayStationMediator mediator;
    
    public TrainLine(RailwayStationMediator mediator){
        this.mediator = mediator;
        mediator.setArrivelStatus(true);
    }

    @Override
    public void arrive() 
    {
        System.out.println("Arrivel permission granted.");
        mediator.setArrivelStatus(false);
    }
}
