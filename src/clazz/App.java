package clazz;

public class App {
    //HW Creati classa persona (numele, familia, salariu)
    //Obiectul eu = valori (cu metode)
    // media a 3 luni salariu
    public static void main(String[] args) {
        Salariu salariu = new Salariu();
        Person p = new Person();
        p.name = "Andrei";
        p.last = "M";
        p.age = 24;
        System.out.println(p);
        salariu.setPerson(p);
        System.out.println("L1:"+salariu.getM1());
        System.out.println("L2:"+salariu.getM2());
        System.out.println("L3:"+salariu.getM3());
    }
}
