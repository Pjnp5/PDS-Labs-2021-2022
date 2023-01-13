

package lab06.ex2;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactsList implements ContactsInterface{
    private List<Contact> contactos;

    public ContactsList() {
        this.contactos = new ArrayList<>();
    }

    @Override
    public void openAndLoad(ContactsStorageInterface store){
        this.contactos.addAll(store.loadContacts());
    }

    @Override
    public void saveAndClose(){

        if(contactos.size() == 0){
            return;
        }
        Scanner input = new Scanner(System.in);


        System.out.println("Pass the file name to save the contacts  (lab06/ex2/files/)");
        String file = input.nextLine(); 

        ContactsStorageInterface storageContact = new ImpleContacts(new File("lab06/ex2/files/" + file));

        storageContact.saveContacts(contactos);

    }

    @Override
    public void saveAndClose(ContactsStorageInterface store){

        if (contactos.size() == 0){
            return;
        }

        store.saveContacts(contactos);

    }
    
    @Override
    public boolean exist(Contact contact){
        for (Contact contacto : contactos) {
            if(contacto.equals(contact)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Contact getByName(String name){
        for (Contact contacto : contactos) {
            if(contacto.getNome().equals(name)){
                return contacto;
            }
        }
        return null;
    }

    @Override
    public boolean add(Contact contact){
        if(exist(contact)){
            return false;
        }
        contactos.add(contact);
        return true;

    }

    @Override
    public boolean remove(Contact contact){
        if(!exist(contact)){
            return false;
        }
        contactos.remove(contact);
        return true;
    }
    
}
