package method;

import java.util.Scanner;

public class Mth {
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Start");
        System.out.println(f("A", "B", f(10, 23,23)));
        System.out.println("End");

    }
    public static int f(int a, int b, int c){
        return a + b + c;
    }
    public static String f(String name, String last){
        return name + " " + last;
    }
    public static String f(String name, String last, int media){
        return f(name, last) + " are o medie de " + media;
    }
    public static void media(double s1, double s2, double s3){
        System.out.println("Media:"+(s1+s2+s3)/3);
//        media(s1, s2, s3+1);
    }

}
