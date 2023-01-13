public class PlasticBottle extends Container{
    Portion menu;
    
    public PlasticBottle(Portion menu) {
        this.menu = menu;
    }
    public Portion getPortion() { // portion in this container
        return menu;
    }
    public void setPortion(Portion menu) { // Set a new portion
        this.menu = menu;
    }
    public Temperature getTemperature() { // Get the temperature of the portion
        return Temperature.COLD;
    }
    public State getState() { // Get the state of the portion
        return State.liquid;
    }
    @Override
    public String toString() {
        return String.format("PlasticBottle with portion = %s", menu.toString());
    }
}
