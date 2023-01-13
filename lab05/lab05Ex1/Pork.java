public class Pork extends PortionFactory implements Portion{

    @Override
    public String toString() {
        return String.format("Pork: Temperature %s, State %s", getTemperature(), getState());
    }

    @Override
    public Temperature getTemperature() {
        return Temperature.WARM;
    }

    @Override
    public State getState() {
        return State.solid;
    }
    
    
}
