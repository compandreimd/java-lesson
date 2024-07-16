package homework;

import org.jetbrains.annotations.NotNull;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HW6 {

    public static void main(String[] args) {
        System.out.print("Get lines?:");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println("Have:");
        var map = countChars(line);
        for (var c : map.entrySet()) {
            System.out.println("'"+c.getKey()+"':\t"+ c.getValue() +"||"+ Character.getName(c.getKey()));
        }
    }

    public static @NotNull Map<Character, Integer> countChars(String str){
        TreeMap<Character, Integer> rs = new TreeMap<>();
        if(str == null)  return rs;
        for(Character c : str.toUpperCase(Locale.ROOT).toCharArray()) {
            if(rs.containsKey(c)){
                rs.put(c, rs.get(c)+ 1);
            }
            else {
                rs.put(c, 1);
            }
        }
        return rs;
    }
}
