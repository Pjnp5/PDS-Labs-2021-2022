package ex2;
public class BurgerChef extends Chef{
    public void cook(String request){
        if (canCook(request, "burger")){
            String[] r = request.split(" ");
            String r2 = "";
            for (int i = 5; i < r.length; i++){
                r2 += r[i] + " ";
            }
            System.out.println("BurgerChef: Starting to cook " + r2+ ". Out in 19 min");
        }
        else{
            System.out.println("BurgerChef: I can't cook that");
            super.cook(request);
        }
    }
    
}
