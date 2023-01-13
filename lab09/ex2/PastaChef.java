package ex2;
public class PastaChef extends Chef{
    public void cook(String request){
        if (canCook(request, "pasta")){
            String[] r = request.split(" ");
            String r2 = "";
            for (int i = 5; i < r.length; i++){
                r2 += r[i] + " ";
            }
            System.out.println("PastaChef: Starting to cook " + r2+ ". Out in 14 min");
        }
        else{
            System.out.println("PastaChef: I can't cook that");
            super.cook(request);
        }
    }
    
}
