package lab11.ex3;

public class Book {
    private State current;
    private String title;
    private int ISBN;
    private int year;
    private String author;
    



    public Book(String title, int ISBN, int year, String author) {
        this.current = new Inventary();
        this.title = title;
        this.ISBN = ISBN;
        this.year = year;
        this.author = author;
    }


    public void setState(State state) {
        current = state;
    }

    public State getState() {
        return current;
    }

    



    @Override
    public String toString() {

        String bookToString = String.format("%-35s %-20s %-10s %-20s [%s]",  this.title, this.author, this.year, this.ISBN, this.current);
        return bookToString;
    }










    
}
