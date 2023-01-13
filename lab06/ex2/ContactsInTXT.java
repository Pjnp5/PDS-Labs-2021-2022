package lab06.ex2;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sound.sampled.Line;

import java.io.FileNotFoundException;
import java.io.FileReader;


public class ContactsInTXT extends ImpleContacts implements ContactsStorageInterface {

    private File file;

    public ContactsInTXT(File file) {
        super(file);
        this.file = file;
    }

    @Override
    public List<Contact> loadContacts() {
        List<Contact> contactos= new ArrayList<>();
        try (Scanner input = new Scanner(new FileReader(file))) {
            while (input.hasNextLine()) {
                
                String[] line = input.nextLine().split("[\\t]");
                Contact contacto = new Contact(line[0], Integer.parseInt(line[1]));
                contactos.add(contacto);
            }
            
            input.close();
        } catch (FileNotFoundException e) {
            System.err.printf("ERRO: %s\n", e.getMessage());
        }
        return contactos;
    }

    @Override
    public boolean saveContacts(List<Contact> list) {
        try (PrintWriter out = new PrintWriter(file)) {
            for (Contact contact : list) {
                out.printf(contact.toString() + "\n");
            }

            out.close();
            return true;
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            return false;        
        }
    }
}
