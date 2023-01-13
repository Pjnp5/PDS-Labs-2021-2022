package ex2;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> requests = new ArrayList<>();
        requests.add("Can I please get a veggie burger ?");
        requests.add("Can I please get a pasta Carbonara ?");
        requests.add("Can I please get a sushi nigiri and sashimi ?");
        requests.add("Can I please get a salad with tuna?");
        requests.add("Can I please get a strawberry ice cream and waffles dessert ?");
        Chef chef = 
            new SushiChef().setSucessor(
                new PastaChef().setSucessor(
                    new BurgerChef().setSucessor(
                        new PizzaChef().setSucessor(
                            new DessertChef()))));
        for (String request : requests){
            System.out.println(request);
            chef.cook(request);
            System.out.println();
        }
    }
    
}
