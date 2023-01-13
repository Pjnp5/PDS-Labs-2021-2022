package ex1B;
public class Employee2 {
    private Person2 person;
    private double salary;
    private BankAccount bankAccount;

    public Employee2(Person2 person, double salary) {
        this.person = person;
        this.salary = salary;
        bankAccount = new BankAccountProxy(new BankAccountImpl("money", 0));
    }

    public Person2 getPerson() {
        return person;
    }

    public double getSalary() {
        return salary;
    }

    public BankAccount getBankAccount() {
        return new BankAccountProxy(bankAccount);
    }
    
}
