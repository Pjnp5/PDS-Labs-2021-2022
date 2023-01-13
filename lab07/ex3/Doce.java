package lab07.ex3;

public class Doce extends Produto{

    public Doce(String nome, double peso) {
        super(nome, peso);
        //TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Doce '" +  getNome() + "' - Weight : " + getPeso();
    }
    
}
