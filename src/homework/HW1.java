package homework;
import java.text.DecimalFormat;
import java.util.Scanner;

public class HW1 {
    private static final DecimalFormat df = new DecimalFormat("0,00");
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
        System.out.println("Media:" + df.format(sum/3));
        System.out.println(ANSI_YELLOW+"Suma depasit de "+ df.format(MAX)+ ": "+ (sum > MAX));
        System.out.println("Media depasita de "+ df.format(MAX)+ ": "+ (sum/3 > MAX));

    }
}
