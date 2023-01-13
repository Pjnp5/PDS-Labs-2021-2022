
public class ConcreteBuilderYogurt implements CakeBuilder{
    //concrete builder for the yogurt cake that implements the interface methods
    protected Cake cake;


    public void setCakeShape(Shape shape){
        cake.setShape(Shape.Circular);
    }

    public void addCakeLayer(){
        cake.setCakeLayer("Yogurt");
        cake.setNumCakeLayers(cake.getNumCakeLayers() + 1);

    }

    public void addCreamLayer(){
        cake.setMidLayerCream(Cream.Vanilla);


    }

    public void addTopLayer(){
        cake.setTopLayerCream(Cream.Red_Berries);


    }

    public void addTopping(){
        cake.setTopping(Topping.Chocolat);

    }
    public void addMessage(String m){
        cake.setMessage(m);

    }

    public void createCake(){
        cake = new Cake();

    }

    public Cake getCake(){
        return cake;
        

    }
}