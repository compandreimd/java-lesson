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
        for (var c : countChars(line).entrySet()) {
            System.out.println("'"+c.getKey()+"':\t"+ c.getValue() +"||"+ Character.getName(c.getKey()));
        }
    }
    public static @NotNull Map<Character, Integer> countChars(@NotNull String str){

        TreeMap<Character, Integer> rs = new TreeMap<>();
        for(Character c : str
                .replaceAll("\\W", "") //Print without space \\s, without not word
                .toUpperCase(Locale.ROOT) // Show only upper case char
                .toCharArray()) // Split in chars
            rs.put(c, rs.get(c) == null ? 1 : rs.get(c) + 1); //Main logic
        return rs;
    }
}
