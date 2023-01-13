public class Tuna extends PortionFactory implements Portion{
    
    @Override
    public String toString() {
        return String.format("Tuna: Temperature %s, State %s", getTemperature(), getState());
    }

    @Override
    public Temperature getTemperature() {
        return Temperature.COLD;
    }

    @Override
    public State getState() {
        return State.solid;
    }
}
