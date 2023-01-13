public class FruitJuice extends PortionFactory implements Portion{
    String fruit;

    public FruitJuice(String fruit) {
        this.fruit = fruit;
    }

    @Override
    public String toString() {
        return String.format("FruitJuice: %s, Temperature %s, State %s", getFlavour(), getTemperature(), getState());
    }

    @Override
    public Temperature getTemperature() {
        return Temperature.COLD;
    }

    @Override
    public State getState() {
        return State.liquid;
    }

    public String getFlavour(){
        return fruit;
    }
    
}
