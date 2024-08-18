package mvn.example.patterns.builder;


import lombok.Getter;

public class St2 {

    @Getter
    private int ani;
    @Getter
    private String nume;
    @Getter
    private String familei;
    @Getter
    private String facultate;
    @Getter
    private int nmr;

    public St2(int ani, String nume, String familei, String facultate, int nmr) {
        this.ani = ani;
        this.nume = nume;
        this.familei = familei;
        this.facultate = facultate;
        this.nmr = nmr;
    }
}
