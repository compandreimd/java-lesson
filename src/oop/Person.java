package oop;

public class Person {

    //incapsularea privat

    private String lastName;
    private String firstName;
    private int age;

    public Person(String name, int age) {
        this.firstName = name;
        this.age = age;
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


}
