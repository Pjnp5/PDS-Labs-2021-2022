package lab09.ex3;

import java.util.Collection;

public class RemoteControl<T> { 
    private Command<T> command;
    
    public void setCommand(Command<T> command) {
        this.command = command;
    }
    public boolean execute(T element) {
        return this.command.execute(element);
    }

    public boolean undo(){
        return this.command.undo();
    }

    public void printList() {
        Collection<T> collection = this.command.getCommands();

        for (T element : collection) {
            System.out.println(element.toString());
        }
    }
}