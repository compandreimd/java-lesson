package forloop;

import java.util.Scanner;

public class ForLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < 10;i++ ) {
            System.out.println("Ce mai face?");
            String res = scanner.nextLine();
            if(!res.equals("bine")) break;
        }
    }

}
