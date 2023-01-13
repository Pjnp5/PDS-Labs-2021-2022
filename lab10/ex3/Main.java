package ex3;
public class Main {
    public static void main(String[] args) {
        RailwayStationMediator mediator = new ArrivelMediator();
        Arrivel IC200 = new Arrivel(mediator);
        TrainLine linha7 = new TrainLine(mediator);
        mediator.registerTrainLine(linha7);
        mediator.registerArrivel(IC200);
        IC200.Arriving();
        linha7.arrive();
        IC200.arrive();

    }
}
