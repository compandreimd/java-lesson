package homework;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Student {
    private static int students;
    private int id;
    private String name;
    private String grup;
    private double nota;

    public static int getStudents() {
        return students;
    }
    public int getId() {
        return id;
    }
    public Student() {
        Student.students++;
        id = Student.students;
    }
    public Student(String name, double nota){
        this();
        this.name = name;
        this.nota = nota;
    }
    public Student(String name, String grup,  double nota) {
        this();
        this.name = name;
        this.nota = nota;
        this.grup = grup;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getNota() {return nota;}
    public void setNota(int nota) {
        this.nota = nota;
    }
    @Override
    public String toString() {
        return name + "\tcu media\t" + nota;
    }
    public static void message(@NotNull Student st1, @NotNull Student st2, Student st3){
        if(st1.getNota() == st2.getNota()){
            if(st2.getNota() == st3.getNota())
                System.out.println("Toti sunt egali. Cu o medie de " + st1.getNota());
            else {
                System.out.println("Primii sunt\t" + st1.getName() +" si " + st2.getName() +".");
                System.out.println("Ultimul est\t" + st3.getName() +". Cu o difirenta " + (st2.getNota() - st3.getNota()));
            }
        }
        else {
            System.out.println("Primul este\t" + st1);
            if(st2.getNota() == st3.getNota())
                System.out.println("Ultimii sunt\t" + st2.getName() +" si " + st3.getName() +". Au diferenta de "+ (st1.getNota() - st2.getNota()));
            else {
                System.out.println("Al doilea\t" + st2+". Cu o diferenta de "+ (st1.getNota() - st2.getNota()));
                System.out.println("Al treilea\t" + st3+". Cu o diferenta de "+ (st2.getNota() - st3.getNota()));
            }
        }
    }
    public static void logic(@NotNull Student st1, @NotNull Student st2, Student st3) {
        Student tmp;
        while (st1.getNota() < st2.getNota() || st2.getNota() < st3.getNota()) {
            tmp = st2;
            st2 = st1;
            st1 = tmp;
            if(st2.getNota() < st3.getNota()){
                tmp = st2;
                st2 = st3;
                st3 = tmp;
            }
        }
        message(st1, st2, st3);
    }
    public static void main(String[] args) {
        Student st1 = new Student("A", 32), st2 = new Student("V", 12), st3 = new Student("C", 22), tmp;

        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);

        int i = 0;
        while(i < 3) {
            System.out.println("Introdu numele studentului "+(++i)+"?");
            String name = scanner.nextLine();
            System.out.println("Introdu media studentului "+(i)+"?");
            double media = scanner2.nextDouble();
            if(i == 1) st1 = new Student(name, media);
            if(i == 2) st2 = new Student(name, media);
            if(i == 3) st3 = new Student(name, media);
        }
        logic(st1, st2, st3);
      //   message(st1, st2, st3);
    }

}
