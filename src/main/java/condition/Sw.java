package condition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Sw {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int sap = 0;
        try {
            sap = scanner.nextInt();
        }
        catch (InputMismatchException error){
            System.err.print("Input ");
        }
        String s =  switch (sap){
            case 1 -> "Luni";
            case 2 -> "Marti";
            case 3 -> "Miercuri";
            case 4 -> "Joi";
            case 5 -> "Vineri";
            case 6 -> "Sambata";
            case 7 -> "Duminica";
            default -> "NO such Week!";
        };
        switch (sap) {
            case 1:
                System.out.println("Luni");
                return;
            case 2:
                System.out.println("Marti");
                break;
            case 3:
                System.out.println("Miercuri");
                break;
            case 4:
                System.out.println("Vineri");
                break;
            case 5:
                System.out.println("Joi");
                break;
            case 6:
                System.out.println("Sambata");
                break;
            case 7:
                System.out.println("Duminica");
                break;
            default:
                System.err.println("Error!");
        }
    }
}
