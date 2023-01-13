package lab06.ex2;
import java.io.File;
import java.util.List;
//Ficheiros têm de ser passados com o path lab06/ex2/FilesTXTBinary/ e apenas com um "." que correponde à extensão do ficheiro

public class Main {
    public static void main(String[] args) {
        //teste txt
        ContactsList cl = new ContactsList();

        File file = new File("lab06/ex2/files/file.txt");
        ContactsStorageInterface st1 = new ImpleContacts(file);

        cl.openAndLoad(st1);

        System.out.println(cl.getByName("Danizinho"));

        cl.add(new Contact("Filipao de ct",985674855));
        System.out.println(cl.getByName("Filipao de ct"));

        cl.remove(cl.getByName("Sobralindo"));
        System.out.println(cl.exist(new Contact("Sobralindo",975649586)));

        ContactsStorageInterface st2 = new ImpleContacts(new File("lab06/ex2/files/saveClose.txt"));
        cl.saveAndClose(st2);

        cl.saveAndClose();



        //test bin
        
        ContactsList cl2 = new ContactsList();

        File file2 = new File("lab06/ex2/files/fileBin.bin");
        ContactsStorageInterface st3 = new ImpleContacts(file2);

        cl2.openAndLoad(st3);

        System.out.println(cl2.getByName("Joana"));

        cl2.add(new Contact("Vera",987645285));
        System.out.println(cl2.getByName("Vera"));

        cl2.remove(cl2.getByName("Carlinha"));
        System.out.println(cl2.exist(new Contact("Carlinha",987364578)));

        ContactsStorageInterface st4 = new ImpleContacts(new File("lab06/ex2/files/BinarySaveClose.bin"));
        cl2.saveAndClose(st4);
        cl2.saveAndClose();
    
    }
}
