package lab07.ex1;

import java.util.Date;

public class Main {
    public static void main(String[] args) {

        System.out.println("Start the program ...");

        InterfaceTF employee1 = new Employee("Danizinho Figs");
        InterfaceTF employee2 = new Employee("Pedro Sobras");
        TeamMember tmember1 = new TeamMember(new Employee("André Freixinho"));
        TeamLeader tleader1 = new TeamLeader(employee1);
        Manager maneger1 = new Manager(new TeamLeader(new TeamMember(employee2)));

        Date date = new Date();
        InterfaceTF listWithEmployees[] = {employee1, employee2, tmember1, tleader1, maneger1};
        for (InterfaceTF emp : listWithEmployees) {
            emp.start(date);
            emp.work();
            emp.terminate(date);
        }
        System.out.println("End the program ...");
        
        
    }
    
}
