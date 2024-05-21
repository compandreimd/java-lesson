package condition;

import java.util.Scanner;

public class Ifs {
    // if(logica) ; //corpul
    public static void mIf() {
        Scanner scanner = new Scanner(System.in);
        int a  = 0;
        System.out.println("Introdu un numar?");
        a = scanner.nextInt();
        if(a % 2 == 0) System.out.println("Este par!");

    }
    // if(logica) ; //corpul else //corpul-else
    public static void mIfElse() {
        Scanner scanner = new Scanner(System.in);
        int a  = 0;
        System.out.println("Introdu un numar?");
        a = scanner.nextInt();
        if(a % 2 == 0){
            System.out.println("Este par!");
        }
        else {
            System.out.println("Este impar  !");
        }
    }
    public static void mIfElseIf() {
        Scanner scanner = new Scanner(System.in);
        int a  = 0;
        System.out.println("Introdu un numar?");
        a = scanner.nextInt();
        if(a % 3 == 0){
            System.out.println("Este mod 3 este 0!");
        }
        else {
            if(a % 3 == 1){
                System.out.println("Este mod 3 este 1!");
            }
            else {
                System.out.println("Este mod 3 este 2!");
            }
        }
//        if(a % 3 == 0){
//            System.out.println("Este mod 3 este 0!");
//        }
//        else if(a % 3 == 1) {
//            System.out.println("Este mod 3 este 1!");
//        }
//        else
//        {
//            System.out.println("Este mod 3 este 2!");
//        }

    }
}
