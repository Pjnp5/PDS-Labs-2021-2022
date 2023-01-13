package lab07.ex1;

import java.util.Date;

public class TeamLeader extends DecoratorTF{
    
    public TeamLeader(InterfaceTF tf) {
        super(tf);
        
    }

    public void start(Date data){
        tf.start(data);

    }
    public void terminate(Date data){
        tf.terminate(data);

    }
    public void work(){
        System.out.println("É o Lider de equipa");
        tf.work();
        plan();

        
    }


    public void plan(){ 
        System.out.println("Está a planear ...");

        
    }
    
}
