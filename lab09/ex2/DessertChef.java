package ex2;
public class DessertChef extends Chef{
    public void cook(String request){
        if (canCook(request, "dessert")){
            String[] r = request.split(" ");
            String r2 = "";
            for (int i = 5; i < r.length; i++){
                r2 += r[i] + " ";
            }
            System.out.println("DessertChef: Starting to cook " + r2+ ". Out in 17 min");
        }
        else{
            System.out.println("DessertChef: I can't cook that");
            super.cook(request);
        }
    }
    
}
