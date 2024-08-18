package condition;

import homework.HW1;

import java.util.Scanner;

public class Ex {
    public static void ex1(){
        Scanner scanner = new Scanner(System.in);
        final double MAX;
        //%
        System.out.println("Introduceti maximum pe salariu?");
        MAX = scanner.nextDouble();
        System.out.println("Introduceti salariele a 3 luni?");
        int l1, l2, l3;
        System.out.println("Prima luna?"); l1 = scanner.nextInt();
        System.out.println("A doua luna?"); l2 = scanner.nextInt();
        System.out.println("A treia luna?"); l3 = scanner.nextInt();
        long sum = (l1 + l2 + l3);
        System.out.println("Suma:" + sum);
        System.out.println("Media:" + (sum/3));
        System.out.println((sum > MAX ? HW1.ANSI_YELLOW: HW1.ANSI_RESET)+"Suma depasit de "+ (MAX)+ ": "+ (sum > MAX));
        System.out.println(((sum/3.0) > MAX ? HW1.ANSI_YELLOW: HW1.ANSI_RESET)+"Media depasita de "+ (MAX)+ ": "+ (sum/3.0d > MAX));
        System.out.print(HW1.ANSI_RESET);

    }
    public static void ex2(){
       // %3 => se imaprte la 3
       // %5 => se imaprte la 5
       // %3 % 5

        Scanner scanner = new Scanner(System.in);
        System.out.println("Introdu numarul?");
        int a = scanner.nextInt();
        if(a % 3 == 0 && a % 5 == 0) System.out.println("Se imparte la 5 si 3!");
        else if(a % 3 == 0) System.out.println("Se imparte la 3!");
        else if(a % 5 == 0) System.out.println("Se imparte la 5!");


    }
}
