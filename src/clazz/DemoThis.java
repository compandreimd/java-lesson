package clazz;

public class DemoThis {
    private String nume;
    private int salariu;

    public DemoThis(String nume, int salariu){
        this.nume = nume;
        this.salariu = salariu;
    }
    public DemoThis(){
        this("A", 100);
    }
    public void setSalariu(int salariu) {this.salariu = salariu;}
    public void setNume(String nume) {
        this.nume = nume;
    }
    public int getSalariu() {
        return salariu;
    }
    public String getNume() {
        return nume;
    }
    
}
