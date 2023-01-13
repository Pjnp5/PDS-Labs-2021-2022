package lab10.ex1;

import java.util.ArrayList;
import java.util.List;

public class Produto extends Subject<Estados>{

    private int ctr = 1;
    private int codigo;
    private String descricao;
    private Estados estado;
    private double MaxBid;
    private Observer MaxBidder;

    private List<Integer> Cod_Prod = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();


    public Produto(String descricao, Double preco_base) {
        this.codigo = ++ctr;
        this.Cod_Prod.add(this.codigo);
        
        this.descricao = descricao;

        this.MaxBid = preco_base;
        
        this.estado = Estados.STOCK;
    }
    
    public boolean recv_bid(Produto produto, double bid, Observer observer) {
        if(prod_exists(produto)){
            if(this.estado == Estados.LEILAO){
                if (bid > MaxBid){
                    MaxBid = bid;
                    MaxBidder = observer;
                    this.observers.add(observer);
                    this.Info_Observers("[OBSERVERS] - ["+ produto.descricao +"] Foi colocada uma nova bid de " + bid + " por " + observer.getName());
                    return true;
                }
                else if(bid < this.MaxBid){
                    System.out.println(observer.getName() + ", a tua bid foi inferior à maior oferecida até ao momento, que foi de " + this.MaxBid);
                }
                return false;
            }
            else if (this.estado == Estados.VENDAS){
                this.Info_Observers("[OBSERVERS] - ["+ produto.descricao +"] foi vendido a " + this.MaxBidder.getName() + " por " + this.MaxBid);
                return true;
            }
            return false;
        }
        else {System.out.println("O produto não existe!"); return false;}

    }

    @Override
    public String toString(){
        return this.descricao;
    }

    public boolean prod_exists(Produto produto){
        int cod_produto = produto.getCodigo();

        if (this.Cod_Prod.contains(cod_produto)) return true;
        return false;

    }

    private int getCodigo() {
        return this.codigo;
    }

    public void setEstado(Estados estado){
        this.estado = estado;

        if(this.estado == Estados.VENDAS){
            this.recv_bid(this, 0.0, null);
        }
    }

    private void Info_Observers(String update_msg) {   // update observers 
        for (Observer observer : this.observers){
            if (this.MaxBidder.getName() != observer.getName()){
                observer.update(update_msg); 
            }
        }
    }

    public void registar_Observer(Observer observer) {   // registar um observer -> adiconar ao array
        if (!this.observers.contains(observer)){
            observers.add(observer);
        }
    }

}
