package lab10.ex1;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        Produto p1 = new Produto("Bolo de Chocolate", 10.0);
        Produto p2 = new Produto("Garrafa de água", 20.0);
        Produto p3 = new Produto("Bolachas", 30.0);
        Produto p4 = new Produto("Manco", 40.0);
        Produto p5 = new Produto("Sanidade Mental", 50.0);
    
        Cliente cl1 = new Cliente("Soralexina");
        Cliente cl2 = new Cliente("Pareidreds");
        Cliente cl3 = new Cliente("Sara Bania");
    
        Gestor gestor = new Gestor("PP II");

        p1.registar_Observer(gestor);

        p1.registar_Observer(gestor);
        p2.registar_Observer(gestor);
        p3.registar_Observer(gestor);
        p4.registar_Observer(gestor);
        p5.registar_Observer(gestor);

        p2.setEstado(Estados.LEILAO);
        p1.setEstado(Estados.LEILAO);

        cl1.send_bid(p2, 23.3);
        System.out.println("--------------------------------------------------");
        
        Thread.sleep(500);
        cl1.send_bid(p1, 12.65);
        System.out.println("--------------------------------------------------");
    
        Thread.sleep(500);
        p3.setEstado(Estados.LEILAO);

        Thread.sleep(500);
        cl2.send_bid(p3, 41.23);
        System.out.println("--------------------------------------------------");

        Thread.sleep(500);
        cl3.send_bid(p3, 36.71);
        System.out.println("--------------------------------------------------");

        p4.setEstado(Estados.LEILAO);
        p5.setEstado(Estados.LEILAO);

        Thread.sleep(500);
        cl2.send_bid(p2, 25.90);
        System.out.println("--------------------------------------------------");
        
        Thread.sleep(500);
        p2.setEstado(Estados.VENDAS);
        System.out.println("--------------------------------------------------");

        Thread.sleep(500);
        p1.setEstado(Estados.VENDAS);
        System.out.println("--------------------------------------------------");

        Thread.sleep(500);
        cl3.send_bid(p3, 46.02);
        System.out.println("--------------------------------------------------");

        Thread.sleep(500);
        p3.setEstado(Estados.VENDAS);
        System.out.println("--------------------------------------------------");

        p4.setEstado(Estados.STOCK);
        p5.setEstado(Estados.STOCK);
    }

}
