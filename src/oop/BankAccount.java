package oop;

public class BankAccount {
    private double amount;
    public void deposit(double amount){
        this.amount += amount;
    }
    public void withdraw(double amount){
        this.amount -= amount;
    }
    public double getAmount() {
        return amount;
    }
}
