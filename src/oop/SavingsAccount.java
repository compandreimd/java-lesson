package oop;

public class SavingsAccount extends BankAccount{
    @Override
    public void withdraw(double amount) {
        //super.withdraw(amount);
        if(this.getAmount() - amount <= 100) {
            System.out.println("Min. 100$");
            return;
        }
        super.withdraw(amount);
    }
}
