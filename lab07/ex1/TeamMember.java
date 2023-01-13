package lab07.ex1;

import java.util.Date;

public class TeamMember extends DecoratorTF{


    public TeamMember(InterfaceTF tf) {
        super(tf);
        
    }

    public void start(Date data){
        tf.start(data);

    }
    public void terminate(Date data){
        tf.terminate(data);

    }
    public void work(){
        System.out.println("É um membro da equipa");
        tf.work();
        colaborate();

        
    }


   
    public void colaborate(){ 
        System.out.println("A colaborar ...");



    }
    

    
}
