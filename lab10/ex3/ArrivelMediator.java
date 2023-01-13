package ex3;
public class ArrivelMediator implements RailwayStationMediator{
    private Arrivel arrivel;
    private TrainLine trainLine;
    public boolean arrive;

    public void registerTrainLine(TrainLine trainLine){
        this.trainLine = trainLine;

    }
    public void registerArrivel(Arrivel arrivel){
        this.arrivel = arrivel;

    }
    public boolean canArrive(){

        return arrive;
    }
    public void setArrivelStatus(boolean status){
        arrive = status;

    }


    
}
