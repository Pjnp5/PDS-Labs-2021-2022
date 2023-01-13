public class Milk extends PortionFactory implements Portion{
    
    @Override
    public String toString() {
        return String.format("Milk: Temperature %s, State %s", getTemperature(), getState());
    }

    @Override
    public Temperature getTemperature() {
        return Temperature.WARM;
    }

    @Override
    public State getState() {
        return State.liquid;
    }



}