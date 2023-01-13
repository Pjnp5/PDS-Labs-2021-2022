public class PlasticBag extends Container{
    Portion menu;
    
    public PlasticBag(Portion menu) {
        this.menu = menu;
    }
    public Portion getPortion() { // Get the selected portion in this container
        return menu;
    }
    public void setPortion(Portion menu) { // Set a new portion for this container
        this.menu = menu;
    }
    public Temperature getTemperature() { // Get the temperature of the portion in this type of containers
        return Temperature.COLD;
    }
    public State getState() { // Get the state of the portion in this type of containers
        return State.solid;
    }

    @Override
     public String toString() {
         return String.format("PlasticBag with portion = %s", menu.toString());
    }
}