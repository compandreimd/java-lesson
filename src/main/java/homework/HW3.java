package homework;

import java.util.Scanner;

public class HW3 {
    public static int SIZE = 5;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max;
        System.out.print("Cate elemente:");
        SIZE = scanner.nextInt();
        int[]  sir = new int[SIZE];
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
        System.out.print("\r\nPart 3:");
        for(int i = 0; i < SIZE; i+=2) {
            System.out.print(" " + sir[i]);
          //  if (max < sir[i]) max = sir[i];
        }
        System.out.print("\r\nPart 4:");
        for(int i = 1; i < SIZE; i+=2) {
            System.out.print(" " + sir[i]);
            //  if (max < sir[i]) max = sir[i];
        }
        System.out.print("\r\nPart 5:");
        for(int i = SIZE/2; i < SIZE; i++) {
            System.out.print(" " + sir[i]);
            if (max < sir[i]) max = sir[i];
        }
        System.out.print("\r\nMAX:"+max);

        for (int i = 0; i < SIZE; i++) {
            for (int j = i + 1; j < SIZE; j++) {
                int tmp;
                if(sir[i] > sir[j]){
                    tmp = sir[i];
                    sir[i] = sir[j];
                    sir[j] = tmp;
                }
            }
        }
        System.out.print("\r\nSORT:");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(" " + sir[i]);
        }

    }
}
