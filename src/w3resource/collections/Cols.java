package w3resource.collections;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.List;

import static collection.list.Helper.contain;
import static collection.list.Helper.dublicate;

public class Cols {

    public static void  p1(){
        ArrayList<String> colors = new ArrayList<>();
        colors.add("red");
        colors.add("green");
        colors.add("blue");
        colors.add("purple");
        colors.add("orange");
        colors.add("white");
        colors.add("black");
        for (int i = 0; i < colors.size(); i++) {
            System.out.println(colors.get(i));
        }
        String str = "blue";
        System.out.println("Have "+str + ":" + contain(colors, str));
        System.out.println("Is Duplicate "+str + ":" + dublicate(colors, str));
    }
    public static void main(String[] args) {
        p1();
    }
}
