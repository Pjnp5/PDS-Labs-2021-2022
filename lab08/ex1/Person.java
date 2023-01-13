package ex1;

public class Person {
    private String name;
    private BankAccount bankAccount;
    public Person(String n) {
        name = n;
        bankAccount = new BankAccountImpl("PeDeMeia", 0);
    }
    public String getName() {
        return name;
    }
    //instead of returning the bankAccount we will be returning the BankAccountProxy,
    // so it can make the validation (is it an employee or the company).
    public BankAccount getBankAccount() {
        return new BankAccountProxy(bankAccount);
    }

    
}