package lab07.ex3;

public class Conserva extends Produto{

    public Conserva(String nome, double peso) {
        super(nome, peso);
        //TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Conserva '" +  getNome() + "' - Weight : " + getPeso();
    }
    
}
