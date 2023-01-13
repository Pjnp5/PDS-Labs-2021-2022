package lab11.ex3;

public class Available implements State{

    @Override
    public void register(Book book) {
        System.err.println("Operation not available\n");
        
    }

    @Override
    public void request(Book book) {
        book.setState(new Borrowed());
        
    }

    @Override
    public void returnBook(Book book) {
        System.err.println("Operation not available\n");
        
    }

    @Override
    public void cancelReserve(Book book) {
        System.err.println("Operation not available\n");
        
    }

    @Override
    public void reserve(Book book) {
        book.setState(new Reserved());
        
    }
    @Override
    public String toString() {
        return "Available";
    }
    
}
