public abstract class Container implements Portion{
    public static Container create(Portion Menu){
        if(Menu == null) return null;

        Container[] Containers = new Container[] {new PlasticBottle(Menu), new TermicBottle(Menu), new Tupperware(Menu), new PlasticBag(Menu)};
        for (Container container : Containers){
            // Check which container matchs the Portion atributes
            if(Menu.getTemperature().equals(container.getTemperature()) && Menu.getState().equals(container.getState())){
                return container;   
            }
        }
        return null;
    }
    
}
