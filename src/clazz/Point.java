package clazz;

import java.math.BigInteger;
import java.util.Scanner;

public class Point {
    public String name;
    public int x;
    public int y;
    BigInteger bigInteger;
    public Point(String name, int x){
        this.name =  name;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        if(x == y){
            return name+"("+x+")";
        }
        return name+"("+x+","+y+")";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give me a name?");
        String name = scanner.nextLine();
        System.out.println("Give me a x?");
        Point p = new Point(name, scanner.nextInt());
        System.out.println("Give me a name?");
        scanner.nextLine();
        System.out.println(p);
    }
}
