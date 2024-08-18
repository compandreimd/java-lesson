package main.java.oop;

public class Programmer extends Employee {

    public Programmer(String name, int age, String address) {
        super(name, age, address);
    }

    @Override
    public double bonus() {
        return 120;
    }
}
