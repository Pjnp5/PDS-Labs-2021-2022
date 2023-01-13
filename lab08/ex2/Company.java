package lab08.ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {
    public static User user;
    private List<Employee> emps = new ArrayList<>();
    private List<Card> Emp_Cards = new ArrayList<>();
    private Parking Emp_Parking= new Parking();
    private SocialSecurity Emp_Social_Security = new SocialSecurity();
    private Insurance Emp_Insurance = new Insurance();



    public void admitEmployee(Person person, int salary) {
        Employee e = new Employee(person, salary);
        emps.add(e);
        this.NewCard(e.getPerson().getName());
        this.Emp_Insurance.regist(person);
        this.Emp_Social_Security.regist(person);
        if (e.getSalary() > GetAverageSalary()){
            System.out.println(e.getPerson().getName()+ " has acess to the parking lot");
            Emp_Parking.allow(person);
        }
    }


    public void paySalaries(int month) {
        for (Employee e : emps) {
            BankAccount ba = e.getBankAccount();
            ba.deposit(e.getSalary());
        }
    }
    public List<Employee> employees() {
        return Collections.unmodifiableList(emps);
    }


    public void NewCard(String name){

        Emp_Cards.add(new Card(name));
    }

    public double GetAverageSalary(){
        double Total_Emp_Salaries=0;
        for(Employee e : emps){
            Total_Emp_Salaries+=e.getSalary();
        }
        Total_Emp_Salaries=Total_Emp_Salaries/emps.size();
        return Total_Emp_Salaries;
    }
    
}
