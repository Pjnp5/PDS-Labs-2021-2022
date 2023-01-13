package ex2;
public class PizzaChef extends Chef {
    public void cook(String request){
        if (canCook(request, "sushi")){
            String[] r = request.split(" ");
            String r2 = "";
            for (int i = 5; i < r.length; i++){
                r2 += r[i] + " ";
            }
            System.out.println("PizzaChef: Starting to cook " + r2+ ". Out in 7 min");
        }
        else{
            System.out.println("PizzaChef: I can't cook that");
            super.cook(request);
        }
    }
    
}
