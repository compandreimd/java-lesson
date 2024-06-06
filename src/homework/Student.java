package homework;

import java.util.Scanner;

public class Student {
    String name;
    int nota;

    Student(String name, int nota){
        this.name = name;
        this.nota = nota;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public static void main(String[] args) {
        Student st1, st2, st3;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introdu nume?");

    }
}
