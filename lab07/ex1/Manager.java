package lab07.ex1;

import java.util.Date;

public class Manager extends DecoratorTF{

    public Manager(InterfaceTF tf) {
        super(tf);
        
    }

    public void start(Date data){
        tf.start(data);

    }
    public void terminate(Date data){
        tf.terminate(data);

    }
    public void work(){
        System.out.println("É o team Manager");
        tf.work();
        manage();

        
    }


   
    public void manage(){ 
        System.out.println("A fazer gestão ... ");



    }
    
}
