public class PortionFactory{
    static String Fruit = "Orange";
    public static Portion create(String food_type, Temperature temp_type){
        Portion[] possiblePortions = new Portion[] { new Milk(), new FruitJuice(Fruit), new Tuna(), new Pork()};
        State state;
        if(food_type.equals("Beverage")){ // Beverage -> Liquid
            state = State.liquid;
        } else if(food_type.equals("Meat")){ // Meat -> Solid
            state = State.solid;
        } else {
            System.out.printf("This type of food was not identified: %s", food_type);
            return null;
        }
        for (Portion portion : possiblePortions){
            // Check which portion matchs the state and temperature selected
            if(portion.getTemperature().equals(temp_type) && portion.getState().equals(state)){
                return portion;
            }
        }
        return null;
    }
    public static Portion create(String food_type, Temperature temp_type, String fruit_type){
        Fruit = fruit_type;
        return create(food_type, temp_type);                                                     
    }
}