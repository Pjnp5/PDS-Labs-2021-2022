package ex2;
public class Chef {
    private Chef sucessor = null;
    public void cook(String request){
        if (sucessor != null){
            sucessor.cook(request);
        }
        else{
            System.out.println("We're sorry but that request can't be satisfied by our service!");
        }
    }
    protected boolean canCook(String request, String food){
        return (request == null) || request.contains(food);
    
    }
    public Chef setSucessor(Chef sucessor){
        this.sucessor = sucessor;
        return this;
    }
    
}