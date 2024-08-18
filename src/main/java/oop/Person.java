package oop;

public class Person {

    //incapsularea privat

    private String lastName;
    private String firstName;
    private String address;
    private int age;

    public Person(String name, int age, String address) {
        this.firstName = name;
        this.age = age;
        this.address = address;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if(age < 18)
            System.out.println("Are too small!");
        else
            this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "P";
    }
}
