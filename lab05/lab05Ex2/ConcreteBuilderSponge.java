
public class ConcreteBuilderSponge implements CakeBuilder{
    //concrete builder for the sponge cake that implements the interface methods
    protected Cake cake;


    public void setCakeShape(Shape shape){
        cake.setShape(shape);
    }

    public void addCakeLayer(){
        cake.setCakeLayer("Sponge");
        cake.setNumCakeLayers(cake.getNumCakeLayers() + 1);

    }

    public void addCreamLayer(){
        cake.setMidLayerCream(Cream.Red_Berries);


    }

    public void addTopLayer(){
        cake.setTopLayerCream(Cream.Whipped_Cream);


    }

    public void addTopping(){
        cake.setTopping(Topping.Fruit);

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