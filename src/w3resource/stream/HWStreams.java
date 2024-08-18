package w3resource.stream;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class HWStreams {
    public static void main(String[] args) {
        List<Integer> li = new ArrayList<>();
        li.add(203);
        li.add(124);
        li.add(1111);
        li.add(1112);
        li.add(1113);
        li.add(1114);
        li.add(90);
        li.add(123);
        li.add(90);
        li.add(130);
        li.add((int)("\uD857\uDE56").toCharArray()[0]);
        li.add((int)("\uD857\uDE56").toCharArray()[1]);
        li.add(85);
        List<String> ls = li.stream().map(x -> "Key" +x+":"+Character.toString(x)).toList();
        System.out.println(average(li));
        System.out.println(transform(ls, Case.Lower, Locale.KOREA));
        System.out.println(transform(ls, Case.Lower));
        System.out.println(transform(ls, Case.Upper));
        System.out.println(transform(ls, Case.Upper, Locale.JAPAN));
        System.out.println(count(ls, "Key"));
        System.out.println(count(ls, "ey", 1));
        System.out.println(sort(li, SortStr.Dsc));
        System.out.println(sort(li, SortStr.Asc));
        System.out.println(removeDub(li));
        System.out.println(removeDub(ls));
        System.out.println(sum(li, SumType.All));
        System.out.println(sum(li, SumType.EVEN));
        System.out.println(sum(li, SumType.ODD));
        System.out.println(find(li, FindNumber.Min));
        System.out.println(find(li, FindNumber.MinSecond));
        System.out.println(find(li, FindNumber.MaxSecond));
        System.out.println(find(li, FindNumber.Max));


    }
    public static double average(List<Integer> list){
        if(list == null) return 0;
        Integer sum = list.stream().reduce(0, (a, b) -> b == null ? a : a+b);
        return (sum) / (double)list.size();
    }
    public enum Case{
        Upper,
        Lower
    }
    public static @Nullable List<String> transform(@Nullable List<String> list, Case c){
        if(list == null) return null;
        return list.stream().map(s-> switch (c){
            case Lower -> s.toLowerCase();
            case Upper -> s.toUpperCase();
        }).toList();
    }
    public static long count(List<String> list, String startWith){
        if(list == null) return 0;
        return list.stream().filter(s -> s != null && s.startsWith(startWith)).count();
    }
    public static long count(List<String> list, String startWith, int offset){
        if(list == null) return 0;
        return list.stream().filter(s -> s != null && s.startsWith(startWith, offset)).count();
    }
    public enum SortStr {
        Asc,
        Dsc
    }
    public static List<Integer> sort(List<Integer> list, SortStr sort){
        return sort == SortStr.Asc ? list.stream().sorted().toList() : list.stream().sorted(Comparator.reverseOrder()).toList();
    }
    public static List<String> transform(List<String> list, Case c, Locale locale){
        if(list == null) return null;
        return list.stream().map(s->  switch (c){
            case Lower -> s == null ? "" : s.toLowerCase(locale);
            case Upper -> s == null ? "" : s.toUpperCase(locale);
        }).toList();
    }
    @Contract("_ -> new")
    public static <K>  @NotNull List<K> removeDub(List<K> list){
        //return  list.stream().collect(Collectors.toSet()).stream().collect(Collectors.toList());
        return new ArrayList<>(new HashSet<>(list));
    }
    public enum SumType{
        All,
        ODD,
        EVEN
    }
    public static int sum(List<Integer> list, SumType type){
        if(list == null) return  0;
        return list.stream().reduce(0, (a, b) -> switch (type) {
            case All -> b == null ? a : a+b;
            case ODD -> b == null ? a : b % 2 == 1? a+b : a;
            case EVEN -> b == null ? a : b % 2 == 0? a+b : a;
        });
    }
    public enum FindNumber {
        Max,
        Min,
        MaxSecond,
        MinSecond
    }
    public static int find(List<Integer> list, FindNumber type){
        if(list == null) return  0;
        List<Integer> sorted = list.stream().sorted().toList();
        return switch (type) {
            case Max -> sorted.get(sorted.size() -1);
            case MaxSecond -> sorted.get(sorted.size() -2);
            case MinSecond -> sorted.get(1);
            case Min -> sorted.get(0);
        };
    }
}
