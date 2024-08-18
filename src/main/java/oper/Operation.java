package oper;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Operation {

    public static void calc(){
        Scanner scanner = new Scanner(System.in);

       // int[] years = new int[] {120, 210, 34,323};
//        int a = 19;
//        int b = 8;
//        int c =  a + b;
//
//        System.out.print("A=");
//        System.out.println(a);
//        System.out.print("B=");
//        System.out.println(b);
//        System.out.print("C=");
//        System.out.println(c)
        //int year_sum = years[0] +years[1] + years[2] +years[3];
        String name="Andrei";
        String last= "MMM";

        System.out.println(name + " " + last + " age ?");

        int age = 0;
        boolean setedAge = false;
        while (!setedAge) {
            try {
                age = scanner.nextInt();
                setedAge = true;
            } catch (InputMismatchException ex) {
                System.out.println("Wrong int:");
            }
        }

        System.out.println("Varsta mea la anu:" + (age + 1));

    }
}
