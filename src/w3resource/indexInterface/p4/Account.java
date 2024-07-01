package w3resource.indexInterface.p4;

public abstract class Account  implements IAccount{
    private double amount;
    @Override
    public void withdraw(double amount) {
        this.amount -= amount;
    }

    @Override
    public void deposit(double amount) {
        this.amount += amount;
    }
    public double getAmount() {
        return amount;
    }

    @Override
    public void viewBalance() {
        System.out.println("Balance for "+this.toString() + " is " + amount);
    }
}
