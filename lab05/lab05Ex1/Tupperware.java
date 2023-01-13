public class Tupperware extends Container{
    Portion menu;
    
    public Tupperware(Portion menu) {
        this.menu = menu;
    }
    public Portion getPortion() { // Get the selected portion
        return menu;
    }
    public void setPortion(Portion menu) { // Set a new portion
        this.menu = menu;
    }
    public Temperature getTemperature() { // Get the temperature of the portion
        return Temperature.WARM;
    }
    public State getState() { // Get the state of the portion
        return State.solid;
    }
    @Override
    public String toString() {
        return String.format("Tupperware with portion = %s", menu.toString());
    }
}