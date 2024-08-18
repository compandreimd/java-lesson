package cicle;

import java.util.Scanner;

public class Whl {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String s;
        do{
            System.out.println("Hello World!");
            System.out.println("Doriti sa printati?");
            s = scanner.nextLine();
        }while (s.equals("y"));
        System.out.println("Is end!");
    }
}
