package w3resource.base;

import java.util.Locale;
import java.util.Scanner;

public class Conditional {
    Scanner scan = new Scanner(System.in);
    public void Ex1() {
        System.out.print("Input number:");
        int n = scan.nextInt();
        if (n >= 0)
            System.out.println("Number is positive");
        else
            System.out.println("Number is negative");

    }
    public void Ex2() {
        System.out.print("Input a:");
        double a = scan.nextDouble();
        System.out.print("Input b:");
        double b = scan.nextDouble();
        System.out.print("Input c:");
        double c = scan.nextDouble();
        double d = Math.pow(b, 2) - 4 * a * c;
        if (a == 0) {
            if (b == 0)
                System.out.println("No roots!");
            else
                System.out.println("The root is " + c / b);
        } else {
            if (d < 0)
                System.out.println("No roots!");
            else if (d == 0.00d)
                System.out.println("The root is " + (-b / 2 * a));
            else {
                d = Math.sqrt(b);
                System.out.println("The roots are " + ((-b + d) / 2 * a) + " and " + +((-b - d) / 2 * a));
            }
        }

    }
    public void Ex3() {
        double max;
        System.out.print("Input the 1st number:");
        double a = scan.nextDouble();
        max = a;
        System.out.print("Input the 2st number:");
        double b = scan.nextDouble();
        if (b > max) max = b;
        System.out.print("Input the 3st number:");
        double c = scan.nextDouble();
        if (c > max) max = b;
        System.out.print("The greatest: " + max);
    }
    public void Ex4() {
        System.out.print("Input value: ");
        float input = scan.nextFloat();
        String status = "Positive";
        if (input < 0) status = "Negative";

        if (input < 1) {
            System.out.println(status + " small number");
        } else if (input > 1000000) {
            System.out.println(status + " large number");
        } else {
            System.out.println(status + " number");
        }

    }
    public void Ex5(){
        System.out.print("Input value: ");
        int w = scan.nextInt() % 7;
        if(w == 1){
            System.out.println("Monday");
        } else if (w == 2) {
            System.out.println("Tuesday");
        }else if (w == 3) {
            System.out.println("Wednesday");
        }else if (w == 4) {
            System.out.println("Thursday");
        }else if (w == 5) {
            System.out.println("Friday");
        }else if (w == 6) {
            System.out.println("Saturday");
        }else if (w == 0) {
            System.out.println("Sunday");
        }
    }
    public void Ex6() {
        double a, b;
        System.out.print("Input floating-point number:");
        a = scan.nextDouble();
        System.out.print("Input floating-point another number:");
        b = scan.nextDouble();
        if(Math.round(a * 1000)  == Math.round(b * 1000))
            System.out.println("They are same!");
        else
            System.out.println("They are different!");
    }
    public void Ex7() {
        System.out.print("Input a month number: ");
        int m = scan.nextInt() % 12;
        System.out.print("Input a year: ");
        int y = scan.nextInt();
        int day  = 0;
        if(m == 1) {
            day = 31;
            System.out.println("January "+y+" has "+day+" days");
        }
        else if (m == 2){
            if(y % 4 == 0 && (y % 100 != 0 || y % 400 == 0))
                day = 29;
            else
                day = 28;
            System.out.println("February "+y+" has "+day+" days");
        }
        else if (m == 3){
            day = 31;
            System.out.println("Mart "+y+" has "+day+" days");
        }
        else if (m == 4){
            day = 30;
            System.out.println("April "+y+" has "+day+" days");
        }
        else if (m == 5){
            day = 31;
            System.out.println("May "+y+" has "+day+" days");
        }
        else if (m == 6){
            day = 30;
            System.out.println("June "+y+" has "+day+" days");
        }
        else if (m == 7) {
            day = 31;
            System.out.println("July "+y+" has "+day+" days");
        }
        else if (m == 8){
            day = 31;
            System.out.println("August "+y+" has "+day+" days");
        }
        else if (m == 9) {
            day = 30;
            System.out.println("September "+y+" has "+day+" days");
        }
        else if (m == 10){
            day = 31;
            System.out.println("October "+y+" has "+day+" days");
        }
        else if (m == 11){
            day = 30;
            System.out.println("November "+y+" has "+day+" days");
        }
        else if (m == 0){
            day = 31;
            System.out.println("December "+y+" has "+day+" days");
        }

    }
    public void Ex8() {
        System.out.print("Input an alphabet:");
        String l =  scan.nextLine().toLowerCase(Locale.ROOT);
        if(l.length() != 1) {
            System.err.print("Only one character!");
            return;
        }
        char cs[] = new char[2];
        l.getChars(0, 1, cs, 0);
        if(Character.isAlphabetic(cs[0])){
            if(cs[0] == 'a'
                    || cs[0] == 'e'
                    || cs[0] == 'i'
                    || cs[0] == 'o'
                    || cs[0] == 'u'
            ) System.out.println("Input letter is Vowel");
            else
                System.out.println("Input letter is Consonant");
        }
        else {
            System.err.print("Is not letter i know!");
        }
    }
}
