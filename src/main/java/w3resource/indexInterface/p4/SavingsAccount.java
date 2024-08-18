package main.java.w3resource.indexInterface.p4;

public class SavingsAccount extends Account implements IAccount {
    private double interest = 0.01;
    private double limit = 100;

    @Override
    public void withdraw(double amount) {
        if(getAmount() - amount <= limit)
            System.out.println("No access");
        else
            super.withdraw(amount);
    }

    @Override
    public double interest() {
        return getAmount() * interest;
    }
}
