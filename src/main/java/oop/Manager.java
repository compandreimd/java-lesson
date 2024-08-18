package oop;

import java.lang.reflect.Type;

public class Manager extends Employee{

    public Manager(String name, int age, String address) {
        super(name, age, address);
    }

    @Override
    public double bonus() {
        return 150;
    }

    @Override
    public String toString() {
        Type type = this.getClass();

        return super.toString()+"M";
    }
}
