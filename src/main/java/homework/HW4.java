package homework;

import java.util.Scanner;

public class HW4 {

    public static void print(String space, int[] sir){
        if(sir == null)
        {
            System.out.println("Is null!");
            return;
        }
        if(sir.length == 0) {
            System.out.println("Is empty!");
            return;
        }
        int last = sir.length - 1;
        for(int i = 0; i < last ; i++) {
            System.out.print(space+sir[i]+", ");
        }
        System.out.print(space+sir[last]);
    }
    public static void print(String space, String[] sir){
        if(sir == null)
        {
            System.out.println("Is null!");
            return;
        }
        if(sir.length == 0) {
            System.out.println("Is empty!");
            return;
        }
        int last = sir.length - 1;
        for(int i = 0; i < last ; i++) {
            System.out.print(space+sir[i]+", ");
        }
        System.out.print(space+sir[last]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ex(0-4):");
        int size = scanner.nextInt(); //size using as exersize level
        boolean repeat = true;
        int[] sir;
        while (repeat) {
            switch (size) {
                case 0:
                    System.out.print("Size:");
                    size = scanner.nextInt();
                    sir = read(size);
                    System.out.print("Sirul intrare:");
                    print("\t", sir);
                    System.out.print("\r\nMin:");
                    System.out.println(min(sir));
                    break;
                case 1:
                    System.out.print("Size:");
                    size = scanner.nextInt();
                    sir = read(size);
                    System.out.print("Sirul intrare:");
                    print("\t", sir);
                    System.out.print("\r\nSirul sortat:");
                    print("\t", sortMin(sir));
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Size:");
                    size = scanner.nextInt();
                    String[] ssir = readS(size);
                    System.out.print("Sirul intrare:");
                    print("\t", ssir);
                    System.out.print("\r\nSirul sortat:");
                    print("\t", sortMin(ssir));
                    System.out.println();
                    break;
                case 3:
                    System.out.print("Cuvantul:");
                    Scanner scanner1 = new Scanner(System.in);
                    String cuv = scanner1.nextLine();
                    if (isPolidrom(cuv))
                        System.out.println("Este polidrom!");
                    else
                        System.out.println("Nu este polidrom!");
                    break;
                case 4:
                        System.out.println("Give 6 digits number:");
                        if(isLuckyNumber(scanner.nextInt()))
                            System.out.println("Is Lucky Number");
                        else
                            System.out.println("Bad Luck!");
                    break;
                default:
                    System.out.println("No such exersize!");
            }
            System.out.print("Repeat N(<=0) Y(>0)?");
            repeat = scanner.nextInt() > 0;
        }
    }
    public static int[] read(int size){
        Scanner scanner = new Scanner(System.in);
        int[] sir = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Sir "+i+":");
            sir[i] = scanner.nextInt();
        }
        return sir;
    }
    public static String[] readS(int size){
        Scanner scanner = new Scanner(System.in);
        String[] sir = new String[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Sir "+i+":");
            sir[i] = scanner.nextLine();
        }
        return sir;
    }
    public static int[] sortMin(int[] sir){
        for (int i = 0; i < sir.length; i++) {
            for (int j = i+1; j < sir.length; j++) {
                if(sir[i] > sir[j]){
                    int tmp = sir[i];
                    sir[i] = sir[j];
                    sir[j] = tmp;
                }
            }
        }
        return sir;
    }
    public static String[] sortMin(String[] sir){
        for (int i = 0; i < sir.length; i++) {
            for (int j = i+1; j < sir.length; j++) {
                if(sir[i].length() > sir[j].length()){
                    String tmp = sir[i];
                    sir[i] = sir[j];
                    sir[j] = tmp;
                }
            }
        }
        return sir;
    }
    public static int min(int[] sir){
        int tmp = sir[0];
            for (int j = 1; j < sir.length; j++)
                if(tmp > sir[j])
                    tmp = sir[j];
        return tmp;
    }
    public static  boolean isPolidrom(String str){
        if(str == null) return false;
        if(str.length() <= 1) return true;
        str = str.toLowerCase();
        boolean b = true;
        for (int i = 0; i < str.length() /2; i++) {
            b = b && str.charAt(i) == str.charAt(str.length() - i - 1);
        }
        return b;
    }
    public static int[] digi6(int n){
        if(n >= 1E7){
            System.err.println("Number is big than 1 000 000");
        }
        int[] digits = new int[] { 0, 0, 0, 0, 0, 0};
        int i = 0;
        while (n != 0 && i < 6){
            digits[i] = n % 10;
            n /= 10;
            i++;

        }
        return digits;
    }
    public static boolean isLuckyNumber(int num){
        int[] digits =  digi6(num);

        return digits[0] + digits[1] + digits[2] == digits[3] + digits[4] + digits[5];
    }
}
