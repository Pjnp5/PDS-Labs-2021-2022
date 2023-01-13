package lab08.ex2;

public class Employee{
    private Person person;
    private double salary;
    private BankAccount bankAccount;

    public Employee(Person person, double salary) {
        this.person = person;
        this.salary = salary;
        bankAccount = new BankAccountProxy(new BankAccountImpl("money", 0));
    }

    public Person getPerson() {
        return person;
    }

    public double getSalary() {
        return salary;
    }

    public BankAccount getBankAccount() {
        return new BankAccountProxy(bankAccount);
    }
}