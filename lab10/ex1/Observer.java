package lab10.ex1;

public interface Observer {
    public abstract void update(String update_msg); // dar update aos clientes necessários
    public abstract String getType();               // identificar e separar ações entre Gestor e Clientes
    public abstract String getName();               // retorna nome do cliente/gestor 
}
