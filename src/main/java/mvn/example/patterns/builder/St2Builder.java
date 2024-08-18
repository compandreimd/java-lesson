package mvn.example.patterns.builder;

public class St2Builder {
    private int ani;
    private String nume;
    private String familei;
    private String facultate;
    private int nmr;


    public St2Builder setAni(int ani) {
        this.ani = ani;
        return this;
    }

    public St2Builder setNume(String nume) {
        this.nume = nume;
        return this;
    }

    public St2Builder setFamilei(String familei) {
        this.familei = familei;
        return this;
    }

    public St2Builder setFacultate(String facultate) {
        this.facultate = facultate;
        return this;
    }

    public St2Builder setNmr(int nmr) {
        this.nmr = nmr;
        return this;
    }
    public St2 builder(){
        return new St2(ani, nume, familei, facultate, nmr);
    }
}
