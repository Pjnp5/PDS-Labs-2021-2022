package lab10.ex1;

import java.util.List;
import java.util.ArrayList;


abstract class Subject<T>{
    protected List<Observer> observers = new ArrayList<>();
    protected T estado;
    private long Tempo_Leilao = 0;


    public void attach(Observer obs){
        observers.add(obs);
    }

    public void setEstado(T s){
        this.estado = s;
        if(this.estado == Estados.LEILAO){
            this.Tempo_Leilao = System.nanoTime(); 
        }else{
            this.Tempo_Leilao = System.nanoTime() - this.Tempo_Leilao;
        }
    };
}
