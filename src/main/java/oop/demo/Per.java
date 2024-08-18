package main.java.oop.demo;

public class Per {
    private double salariu;
    public static double bonus = 0;

    public Per(double salariu) {
        this.salariu = salariu;
    }

    public double getSalariu() {
        return salariu;
    }

    public void setSalariu(double salariu) {
        this.salariu = salariu;
    }
    public double getSalariuWithBonus() {
        return salariu * (100 + bonus)/100;
    }


}
