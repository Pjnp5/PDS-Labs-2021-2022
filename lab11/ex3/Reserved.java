package lab11.ex3;

public class Reserved implements State{

    @Override
    public void register(Book book) {
        System.err.println("Operation not available\n"); 
        
        
    }

    @Override
    public void request(Book book) {
        System.err.println("Operation not available\n"); 
        
        
    }

    @Override
    public void returnBook(Book book) {
        System.err.println("Operation not available\n"); 
        
        
    }

    @Override
    public void cancelReserve(Book book) {
        book.setState(new Available());
        
    }

    @Override
    public void reserve(Book book) {
        System.err.println("Operation not available\n"); 
        
        
    }

    @Override
    public String toString() {
        return "Reserved";
    }
    
}
