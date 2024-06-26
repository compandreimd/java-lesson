package oop;

public class SavingsAccount extends BankAccount{
    @Override
    public void withdraw(double amount) {
        //super.withdraw(amount);
        System.out.println("no access");
    }
}
