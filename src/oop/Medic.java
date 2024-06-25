package oop;

//inhertance mostinera
public class Medic extends  LicPerson{
    private String type;

    public Medic(String name, int age) {
        super(name, age);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
