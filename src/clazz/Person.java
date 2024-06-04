package clazz;

public class Person {
    String name;
    String last;
    int age;

    public void setAge(int age) {
        this.age = age;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getLast() {
        return last;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return  name + " " + last + "(" + age + ")";
    }
}
