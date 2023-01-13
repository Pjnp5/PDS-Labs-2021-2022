package lab07.ex1;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class Employee implements InterfaceTF  {
    private String nome;
    private Date timeStartShift;
    private Date timeEndingShift;

    Calendar calendar = Calendar.getInstance();


    public Employee()  {
    }

    public Employee(String nome) {
        this.nome = nome;
        
    }
    @Override
    public void start(Date date){
        this.timeStartShift = date;
        calendar.setTime(timeStartShift);
        System.out.println("\nO " + nome +" começou a trabalhar ás " + calendar.getTime() );


    }
    @Override
    public void work(){
        System.out.println("O funcionario "+ nome + " esta a trabalhar");
        
    }
    @Override
    public void terminate(Date date){
        this.timeEndingShift = date;
        calendar.setTime(timeEndingShift);
        calendar.add(Calendar.HOUR_OF_DAY, 8);
        System.out.println("O "+ nome + " acabou de trabalhar, " + calendar.getTime() );


    }
    
   
    

    

    


    
}
