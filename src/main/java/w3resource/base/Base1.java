package w3resource.base;

import java.util.Scanner;

public class Base1 {
    Scanner scanner = new Scanner(System.in);
    public void ex1(){
        System.out.println("Hello");
        System.out.println("Andrei M");
    }
    public void ex2(){
        System.out.println(74+36);
    }
    public void ex3(){
        System.out.println(74+36);
    }
    public void ex4(){
        System.out.println(-5 + 8 * 6);
        System.out.println((55+9) % 9);
        System.out.println(20 + -3*5/8);
        System.out.println(5+15/3 * 2 - 8 % 3);
    }
    public void ex5(){
        int x,y;
        System.out.println("Input first number:");
        x = scanner.nextInt();
        System.out.println("Input second number:");
        y = scanner.nextInt();
        System.out.println(x + "*" + y + "="+(x*y));

    }
}
