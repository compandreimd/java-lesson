package forloop;

import java.util.Scanner;

public class ForLoop {
    public static void main(String[] args) {
        for (int i = 10; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
//        for(int i = 0; i < 5; i++){
//            for (int j = 0; j < 5; j++) {
//                System.out.print("*");
//            }
//            for (int j = 0; j < 5; j++) {
//                System.out.print("_");
//            }
//            System.out.println();
//        }
//        Scanner scanner = new Scanner(System.in);
//        for(int i = 0; i < 10;i++ ) {
//            System.out.println("Ce mai face?");
//            String res = scanner.nextLine();
//            if(!res.equals("bine")) break;
//        }
    }

}
