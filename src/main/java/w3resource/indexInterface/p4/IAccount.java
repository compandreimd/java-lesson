package main.java.w3resource.indexInterface.p4;

public interface IAccount {
    void withdraw(double amount);
    void deposit(double amount);
    double interest();
    void viewBalance();
}
