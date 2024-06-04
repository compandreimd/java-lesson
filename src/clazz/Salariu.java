package clazz;

public class Salariu {
    private Person person = new Person();
    private double m1 = 0;
    private double m2 = 0;
    private double m3 = 0;

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setM1(double m1) {
        this.m1 = m1;
    }

    public void setM2(double m2) {
        this.m2 = m2;
    }

    public void setM3(double m3) {
        this.m3 = m3;
    }

    public Person getPerson() {
        return person;
    }

    public double getM1() {
        return m1;
    }

    public double getM2() {
        return m2;
    }

    public double getM3() {
        return m3;
    }

    public double media(){
        return  (m1+m2+m3)/3;
    }

}
