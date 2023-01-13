package lab07.ex1;

import java.util.Date;
import java.util.Objects;

public class DecoratorTF implements InterfaceTF{

    protected InterfaceTF tf;

    public DecoratorTF(InterfaceTF tf) {
        this.tf = tf;
    }
    
    public void start(Date data){
        tf.start(data);

    }
    public void terminate(Date data){
        tf.terminate(data);

    }
    public void work(){
        tf.work();
    }

    

    


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof DecoratorTF)) {
            return false;
        }
        DecoratorTF decoratorTF = (DecoratorTF) o;
        return Objects.equals(tf, decoratorTF.tf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(tf);
    }

    @Override
    public String toString() {
        return "{" +
            " interfaceTF='" + tf + "'" +
            "}";
    }

   

    
}
