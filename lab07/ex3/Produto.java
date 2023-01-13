package lab07.ex3;

import java.util.Objects;

public abstract class Produto {
    private String nome;
    private double peso;


    

    public Produto(String nome, double peso) {
        this.nome = nome;
        this.peso = peso;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    public Double getPesoTotal(){
        return 0.0;
    }

    public void draw() {
        
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Produto)) {
            return false;
        }
        Produto produto = (Produto) o;
        return Objects.equals(nome, produto.nome) && peso == produto.peso;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, peso);
    }

    @Override
    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            ", peso='" + getPeso() + "'" +
            "}";
    }

    
}
