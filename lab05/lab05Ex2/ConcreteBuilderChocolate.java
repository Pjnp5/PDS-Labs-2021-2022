
public class ConcreteBuilderChocolate implements CakeBuilder{
    //concrete builder for the chocolate cake that implements the interface methods
    protected Cake cake;


    public void setCakeShape(Shape shape){
        cake.setShape(Shape.Circular); //use the enum shape
    }

    public void addCakeLayer(){
        cake.setNumCakeLayers(cake.getNumCakeLayers() + 1);
        cake.setCakeLayer("Soft Chocolate");

    }

    public void addCreamLayer(){


    }

    public void addTopLayer(){
        cake.setTopLayerCream(Cream.Whipped_Cream);//use the enum cream


    }

    public void addTopping(){
        cake.setTopping(Topping.Fruit); //use the enum fruit

    }
    public void addMessage(String m){ //use the meassage read in the contructor
        cake.setMessage(m);

    }

    public void createCake(){
        cake = new Cake();

    }

    public Cake getCake(){
        return cake;
        

    }
    
}
