package lab09.ex3;


import java.util.Collection;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        RemoteControl Remote_Control_to_add = new RemoteControl();
        RemoteControl Remote_Control_to_remove = new RemoteControl();

        Collection elements = new ArrayList<>();

        elements.add("Nó Tijolo e Verde (1)");
        elements.add("Nó Verde (2)");

        Command addCommand = new AddCommand(elements);
        Command removeCommand = new RemoveCommand(elements);

        Remote_Control_to_add.setCommand(addCommand);
        Remote_Control_to_remove.setCommand(removeCommand);


        Remote_Control_to_add.undo();
        Remote_Control_to_add.execute("Nó Castanho (3)");
        System.out.println("------------------");
        Remote_Control_to_add.printList();
        Remote_Control_to_add.undo();        
        System.out.println("------------------");
        Remote_Control_to_add.printList();
        Remote_Control_to_add.execute("Nó Branco (4)");
        Remote_Control_to_add.execute("Rede Verde (5)");        
        System.out.println("------------------");
        Remote_Control_to_add.printList();
        Remote_Control_to_add.undo();


        System.out.println("------------------");
        Remote_Control_to_add.execute("Nó Tijolo e Verde (6)");
        Remote_Control_to_add.printList();
        Remote_Control_to_add.undo();        
        System.out.println("------------------");
        Remote_Control_to_add.printList();

    }
}
