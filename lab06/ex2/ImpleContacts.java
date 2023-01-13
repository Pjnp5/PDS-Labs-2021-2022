package lab06.ex2;

import java.io.File;
import java.util.List;


public class ImpleContacts implements ContactsStorageInterface{
    
    private File file;
    private String extension = "binary";

    public ImpleContacts(File file) {
        //Verificar se isto ta bem
        this.file = file;
        String[] nomeFile = file.getName().split("\\.");
        if(nomeFile.length > 1){
            extension = nomeFile[1];
        }
    }

    @Override
    public List<Contact> loadContacts(){
        ContactsStorageInterface tpStorage; 
        switch (extension) {
            case "txt"://extensao do ficheiro txt
                tpStorage = new ContactsInTXT(file);
                break;
                
            default://binary file
                tpStorage = new ContactsInBinary(file);
                break;
        }

        return tpStorage.loadContacts();
    }

    @Override
    public boolean saveContacts(List<Contact> list){
        ContactsStorageInterface tpStorage; 
        switch (extension) {
            case "txt"://extensao do ficheiro txt
                tpStorage = new ContactsInTXT(file);
                break;

            default://binary file
                tpStorage = new ContactsInBinary(file);
                break;
        }

        return tpStorage.saveContacts(list);
    }
}
