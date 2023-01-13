package ex3;
public interface RailwayStationMediator {
    public void registerTrainLine(TrainLine trainLine);
    public void registerArrivel(Arrivel arrivel);
    public boolean canArrive();
    public void setArrivelStatus(boolean status);
}
