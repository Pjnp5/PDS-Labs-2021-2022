package lab10.ex1;

public class Cliente implements Observer{

    private String nome;

    public Cliente(String nome) { this.nome = nome;}


    public boolean send_bid(Produto produto, double bid){ return produto.recv_bid(produto, bid, this);}

    @Override
    public void update(String update_msg) {
        System.out.println("Alterando a informação do cliente " + this.nome + ": " + update_msg);
        
    }

    @Override
    public String getType() {
        return "Cliente";
    }

    @Override
    public String getName() {
        return this.nome;
    }
    
    
}
