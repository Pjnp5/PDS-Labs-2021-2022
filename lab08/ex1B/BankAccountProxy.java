package ex1B;

public class BankAccountProxy implements BankAccount{
    private BankAccount bank;


    public BankAccountProxy(BankAccount bank) {
        this.bank = bank;
    }

    private Boolean isUser() {
        return (Company2.user == User.OWNER);
    }

    @Override
    public void deposit(double amount) {
        bank.deposit(amount);
        
    }

    @Override
    public boolean withdraw(double amount) {
        if(isUser()) {
            return bank.withdraw(amount);
        }else{
            System.out.println("ERROR: 1, You don't have acess to perform this action");
            return false;
        }
        
    }

    @Override
    public double balance() {
        if(isUser()) {
            return bank.balance();
        }else{
            System.out.println("ERROR: 2, You don't hace acess to perform this action");
            return Double.NaN;
        }
        

    }
    
}
