package homework;

import java.util.Scanner;

public class HW3 {
    public static final int SIZE = 4;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[]  sir = new int[SIZE];
        int max;
        for(int i = 0; i < SIZE; i++) {
            System.out.print("Insert element "+ i+":");
            sir[i] = scanner.nextInt();
        }
        //Show part 1
        max = sir[0];
        System.out.print("Part 1:");
        for(int i = 0; i < SIZE/2; i++) {
            System.out.print(" " + sir[i]);
            if (max < sir[i]) max = sir[i];
           // max = max < sir[i] ? sir[i] : max;
        }
        // \n UNIX \r\n WINDOWS \r (MACOS <= 9) new line
        //Show part 2
        System.out.print("\r\nPart 2:");
        for(int i = SIZE/2; i < SIZE; i++) {
            System.out.print(" " + sir[i]);
            if (max < sir[i]) max = sir[i];
        }
        System.out.print("\r\nMAX:"+max);

    }
}
