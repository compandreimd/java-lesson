package lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Stream {

    public static void main(String[] args)  {
        ArrayList<String> list = new ArrayList<>();
        int[] a = new int[]{
                2, 34, 54,54, 451, 324, 543
        };
        list.add("Sand");
        list.add("o");
        list.add("ra");

        list.stream().map(x -> x.charAt(0)+" "+x).forEach(System.out::println);
//
        //System.out.println(list.stream().filter(a -> a.length() >= 2).toList());
        //  System.out.println(list.stream().collect(Collectors.toMap(a -> a, b -> b.length())));
        Arrays.stream(a)
                .filter(i -> i % 2 == 0).forEach(System.out::println);
       //  Stream s = S
        IntStream d = Arrays.stream(a);
        System.out.println(d.sorted().boxed().toList());

    }
}
