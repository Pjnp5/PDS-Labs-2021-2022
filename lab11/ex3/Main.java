package lab11.ex3;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Library library = new Library("Livros da Marta");

        library.addBook(new Book("Histórias extraordinárias", 2345, 1845, "Edgar Alan Poe"));
        library.addBook(new Book("Red Queen", 2345, 2012, "Victoria Aveyard"));
        library.addBook(new Book("Kings Cage", 2345, 2012, "Victoria Aveyard"));
        library.addBook(new Book("Emma", 2345, 1815, "Jane Austen"));
    
        List<Book> bookList = library.returnBook();

        while (true) {
            System.out.println("*** Biblioteca ***");
            int i = 0;
            for (Book book : bookList) {
                i++;
                System.out.println(i+ "     " + book);
            }
            System.out.println(">> <livro>, <operação>: (1) regista; (2) requisita; (3) devolve; (4) reserva; (5) cancela");
            System.out.printf(">> ");
            try{
                String[] input = sc.nextLine().split(",");
                int livro_field = Integer.parseInt(input[0]);
                int operacao_field = Integer.parseInt(input[1]);
                Book book = bookList.get(livro_field - 1);
                menu(library, book, operacao_field);
            }
            catch (NumberFormatException e){
                System.err.println("\nError: Wrong input format, please try again. Input example:\n>>1,1\n");
                continue;
            }
        }
    }

    public static void menu(Library library, Book book, int operation) {
        switch (operation) {
            case 1:
                library.register(book);
                break;
            case 2:
                library.request(book);
                break;
            case 3:
                library.returnBook(book);
                break; 
            case 4:
                library.reserve(book);
                break;
            case 5:
                library.cancelReserve(book);
                break;
        }
    }

    
    
    
    
}
