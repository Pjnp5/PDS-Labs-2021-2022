package lab11.ex3;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private String name;
    List<Book> booksList = new ArrayList<Book>(); 


    public Library(String name) {
        this.name = name;
    }

    public void addBook(Book book) {
        booksList.add(book);
    }


    public List<Book> returnBook() {
        List<Book> list = new ArrayList<>();
        for (Book book : booksList){
            list.add(book);
        }
        return list;
    }


    public String getName() {
        return name;
    }

    public void register(Book book) {
        book.getState().register(book);
    }

    
    public void request(Book book){
        book.getState().request(book);

    }
    public void returnBook(Book book){
        book.getState().returnBook(book);

    }
    public void cancelReserve(Book book){
        book.getState().cancelReserve(book);

    }
    public void reserve(Book book){
        book.getState().reserve(book);

    }






    
    
}
