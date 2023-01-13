package lab10.ex1;

public class Gestor implements Observer{

    private String nome;

    public Gestor(String nome) {
        this.nome = nome;
    }

    @Override
    public void update(String update_msg) {
        System.out.println("Alterando a informação do Gestor " + this.nome + ": " + update_msg);
    }

    @Override
    public String getType() {
        return "Gestor";
    }

    @Override
    public String getName() {
        return this.nome;
    }
    
}
