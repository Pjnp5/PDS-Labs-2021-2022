public class Cake {

    private Shape shape;
    private String cakeLayer;
    private int numCakeLayers = 0;
    private Cream midLayerCream;
    private Cream topLayerCream;
    private Topping topping;
    private String message;


    public Cake() {
    }

    public Cake(Shape shape, String cakeLayer, int numCakeLayers, Cream midLayerCream, Cream topLayerCream, Topping topping, String message) {
        this.shape = shape;
        this.cakeLayer = cakeLayer;
        this.numCakeLayers = numCakeLayers;
        this.midLayerCream = midLayerCream;
        this.topLayerCream = topLayerCream;
        this.topping = topping;
        this.message = message;
    }

    public Shape getShape() {
        return this.shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public String getCakeLayer() {
        return this.cakeLayer;
    }

    public void setCakeLayer(String cakeLayer) {
        this.cakeLayer = cakeLayer;
    }

    public int getNumCakeLayers() {
        return this.numCakeLayers;
    }

    public void setNumCakeLayers(int numCakeLayers) {
        this.numCakeLayers = numCakeLayers;
    }

    public Cream getMidLayerCream() {
        return this.midLayerCream;
    }

    public void setMidLayerCream(Cream midLayerCream) {
        this.midLayerCream = midLayerCream;
    }

    public Cream getTopLayerCream() {
        return this.topLayerCream;
    }

    public void setTopLayerCream(Cream topLayerCream) {
        this.topLayerCream = topLayerCream;
    }

    public Topping getTopping() {
        return this.topping;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Cake shape(Shape shape) {
        setShape(shape);
        return this;
    }

    public Cake cakeLayer(String cakeLayer) {
        setCakeLayer(cakeLayer);
        return this;
    }

    public Cake numCakeLayers(int numCakeLayers) {
        setNumCakeLayers(numCakeLayers);
        return this;
    }

    public Cake midLayerCream(Cream midLayerCream) {
        setMidLayerCream(midLayerCream);
        return this;
    }

    public Cake topLayerCream(Cream topLayerCream) {
        setTopLayerCream(topLayerCream);
        return this;
    }

    public Cake topping(Topping topping) {
        setTopping(topping);
        return this;
    }

    public Cake message(String message) {
        setMessage(message);
        return this;
    }

    @Override
    public String toString() {
        return cakeLayer + " cake with " + numCakeLayers + " layers, topped with " +
         topLayerCream + " cream and " + topping + ". Message says: \"" + message + "\".";
    }

    
}
