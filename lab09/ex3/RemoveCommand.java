package lab09.ex3;

import java.util.Collection;

public class RemoveCommand<T> implements Command<T>{
    private Collection<T> collection;
    private T last_element;
    private boolean undo = false;

    public RemoveCommand(Collection<T> collection){
        this.collection = collection;
    }

    @Override
    public boolean execute(T element) {
        if(collection.remove(element)){
            this.last_element = element;
            undo = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean undo() {
        if(undo){
            boolean result = this.collection.add(last_element);
            undo = false;
            return result;
        }
        System.out.println("Can't undo the last command!");
        return false;
    }

    @Override
    public Collection<T> getCommands() {
        return this.collection;
    }
    
}
