
public class CakeMaster {
    private CakeBuilder cakeBuilder ; //create a new object cakeBuilder

    public void setCakeBuilder(CakeBuilder cake){ // set the cake builder with the users input 
        cakeBuilder = cake;

    }
    public Cake getCake() { //return the created cake
        return cakeBuilder.getCake();
    }
    
    
    public void createCake(String message){ 
        //add all the information from the user for the chocolate cake
        cakeBuilder.createCake();
        cakeBuilder.setCakeShape(Shape.Circular);
        cakeBuilder.addCakeLayer();
        cakeBuilder.addCreamLayer();
        cakeBuilder.addTopLayer();
        cakeBuilder.addTopping();
        cakeBuilder.addMessage(message);
        

        
    }
    public void createCake(Shape shape, int num,String message){
        //add all the information from the user for the sponge cake
        cakeBuilder.createCake();
        cakeBuilder.setCakeShape(shape);
        for (int j = 0; j < num; j++) { // add each layer
            cakeBuilder.addCakeLayer();
            cakeBuilder.addCreamLayer();
        }
        cakeBuilder.addTopLayer();
        cakeBuilder.addTopping();
        cakeBuilder.addMessage(message);
        

        
    }
    public void createCake(int i, String message) {
        //add all the information from the user for the yogurt cake
        cakeBuilder.createCake();
        cakeBuilder.setCakeShape(Shape.Circular);
        for (int j = 0; j < i; j++) {// add each layer
            cakeBuilder.addCakeLayer();
            cakeBuilder.addCreamLayer();
        }
        cakeBuilder.addTopLayer();
        cakeBuilder.addTopping();
        cakeBuilder.addMessage(message);
    }





    
}
