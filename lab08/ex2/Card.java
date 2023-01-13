package lab08.ex2;

public class Card {
    private String name;
    private int ID;
    private static int ctr = 1;


    public Card(String name) {
        this.name = name;
        this.ID = ctr;
        ctr++;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Name: " +  this.name + "ID: " + this.ID;
    }

}
