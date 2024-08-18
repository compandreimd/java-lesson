package oop;

public class Developer extends Employee {
    public Developer(String name, int age, String address) {
        super(name, age, address);
    }

    @Override
    public double bonus() {
        return 110;
    }
}
