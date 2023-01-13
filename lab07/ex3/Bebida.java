package lab07.ex3;

public class Bebida extends Produto{


    public Bebida(String nome, double peso) {
        super(nome, peso);
        //TODO Auto-generated constructor stub
    }

    

    

    @Override
    public String toString() {
        return "Bebida '" +  getNome() + "' - Weight : " + getPeso();
    }
    
}
