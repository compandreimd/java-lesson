package main.java.lamda;

import clazz.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.*;


public class Main {

    // Consumer  (A) -> void
    // BiConsumer  (A, B) -> void
    // Predicate (A) -> boolean
    //BiPredicate  (A, B) -> boolean
    // Function  (A) -> B
    // BiFunction (A, B) -> C
    // Supplier () -> A
    Consumer CO = System.out::println;
    BiConsumer BC = (x, y) -> System.out.println(x.toString() + " " + y.toString());
    Predicate PR = Objects::isNull;
    BiPredicate BP = (x, y) -> x == null || y == null;
    Function FU = (x) -> x;
    BiFunction BF = (a, b) -> a;
    Supplier SU = () -> null;

    @FunctionalInterface
    interface All<A, B, C> {
        C apply(A a, B b);

        default C apply(A a) {
            return apply(a, null);
        }
    }

    public interface A {
        int method(int a, int b);
    }

    public interface Convert<T> {
        void convert(T list);
    }

    public static class Sum implements A {
        @Override
        public int method(int a, int b) {
            return a + b;
        }
    }

    public static void ex() {
        Convert<String[]> upper = (ss -> {
            for (int i = 0; i < ss.length; i++) {
                ss[i] = ss[i].toUpperCase();
            }
        });
        Convert<List<String>> upper2 = (ss -> {
            for (int i = 0; i < ss.size(); i++) {
                ss.set(i, ss.get(i).toUpperCase());
            }
        });
        Convert<String[]> lower = (ss -> {
            for (int i = 0; i < ss.length; i++) {
                ss[i] = ss[i].toLowerCase();
            }
        });
        Convert<List<String>> lower2 = (ss -> {
            for (int i = 0; i < ss.size(); i++) {
                ss.set(i, ss.get(i).toLowerCase());
            }
        });
        String[] lista = new String[]{"Ana", "Ion"};
        List<String> listb = Arrays.asList(lista);

        for (String s : lista)
            System.out.print(s + ",");
        for (String s : listb)
            System.out.print(s + ",");
        System.out.println();
        upper.convert(lista);
        upper2.convert(listb);
        for (String s : lista)
            System.out.print(s + ",");
        for (String s : listb)
            System.out.print(s + ",");
        System.out.println();
        lower.convert(lista);
        for (String s : lista)
            System.out.print(s + ",");
        System.out.println();
    }

    public static void ex2() {
        List<Person> p = new ArrayList<>();
        p.add(new Person("AA", "BA", 10));
        p.add(new Person("AB", "BC", 13));
        p.add(new Person("AC", "BD", 14));
        Convert<List<Person>> showName = a -> {
            for (Person b : a)
                System.out.println(b.getName() + " " + b.getLast());
        };
        showName.convert(p);
    }

    public static void main(String[] args) {

        Function<int[], int[]> para = (l) -> {
            List<Integer> tmp = new ArrayList<>();
            int[] rs = new int[tmp.size()];
            for (int i = 0; i < l.length; i++) {
                if(l[i] % 2 == 0)
                    tmp.add(l[i]);
            }
            return  rs;
        };
        Function<int[], int[]> impare = (l) -> {
            List<Integer> tmp = new ArrayList<>();
            int[] rs = new int[tmp.size()];
            for (int i = 0; i < l.length; i++) {
                if(rs[i] % 2 == 0)
                    tmp.add(rs[i]);
            }
            return  rs;
        };
        int[] list = new int[] {1, 23, 32, 132};
        int[] pare = (para.apply(new int[] {1, 32,43,5}));
        for (int i = 0; i < pare.length; i++) {
            System.out.println(pare[i]);
        }

    }
}
