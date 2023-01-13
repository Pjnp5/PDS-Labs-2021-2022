public class TermicBottle extends Container{
    Portion menu;
    
    public TermicBottle(Portion menu) {
        this.menu = menu;
    }
    public Portion getPortion() { // Get the selected portion in this container
        return menu;
    }
    public void setPortion(Portion menu) { // Set a new portion for this container
        this.menu = menu;
    }
    @Override
    public Temperature getTemperature() { // Get the temperature of the portion in this type of containers
        return Temperature.WARM;
    }
    @Override
    public State getState() { // Get the state of the portion in this type of containers
        return State.liquid;
    }
    @Override
    public String toString() {
        return String.format("TermicBottle with portion = %s", menu.toString());
    }
}
