package lab07.ex3;

import java.util.ArrayList;
import java.util.List;

public class Caixa extends Produto{

    private List<Produto> produtosLst = new ArrayList<>();
    private double pesoTotal = 0;
    protected static StringBuffer str = new StringBuffer();


    public Caixa(String nome, double peso) {
        super(nome, peso);
        //TODO Auto-generated constructor stub
    }
    public void add(Produto p) {
        this.produtosLst.add(p);
        this.pesoTotal += p.getPeso();
    }

    public void draw(){
        for (Produto produto : produtosLst) {
            if( produto instanceof Caixa){
                this.pesoTotal += produto.getPesoTotal();
            }
        }
        this.pesoTotal+=this.getPeso();

        System.out.println(str.toString() + "* " + this.toString());
        str.append("    ");
        for (Produto produto : produtosLst) {

            if (produto instanceof Caixa) {
                produto.draw();
            } else {
                System.out.println(str.toString() + produto);
            }
        }
        str.setLength(str.length() - 4);

    }
    @Override
    public Double getPesoTotal(){
        return this.pesoTotal;
    }

    @Override
    public String toString() {
        return "* Caixa '" + getNome() + "' [Weight: " + getPeso() + "; Total: " + this.pesoTotal + "]";
    }
    
}
