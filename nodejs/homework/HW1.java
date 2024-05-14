package homework;
import java.util.Scanner;

public class HW1 {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static void Media() {
        Scanner scanner = new Scanner(System.in);
        final double MAX;
        System.out.println("Introduceti maximum pe salariu?");
        MAX = scanner.nextDouble();
        System.out.println("Introduceti salariele a 3 luni?");
        double l1, l2, l3;
        System.out.println("Prima luna?");
        l1 = scanner.nextDouble();
        System.out.println("A doua luna?");
        l2 = scanner.nextDouble();
        System.out.println("A treia luna?");
        l3 = scanner.nextDouble();
        double sum = (l1 + l2 + l3);
        System.out.println("Suma:" + sum);
        System.out.println("Media:" + (sum/3));
        System.out.println(ANSI_YELLOW+"Suma depasit de "+ (MAX)+ ": "+ (sum > MAX));
        System.out.println("Media depasita de "+ (MAX)+ ": "+ (sum/3 > MAX));
        System.out.print(ANSI_RESET);
    }
}
