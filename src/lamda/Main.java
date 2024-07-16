package lamda;

import clazz.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
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
    public static void ex(){
        Convert<String[]> upper =  (ss -> {
            for (int i = 0; i < ss.length; i++) {
                ss[i] = ss[i].toUpperCase();
            }
        });
        Convert<List<String>> upper2 =  (ss -> {
            for (int i = 0; i < ss.size(); i++) {
                ss.set(i, ss.get(i).toUpperCase());
            }
        });
        Convert<String[]> lower =  (ss -> {
            for (int i = 0; i < ss.length; i++) {
                ss[i] = ss[i].toLowerCase();
            }
        });
        Convert<List<String>> lower2 =  (ss -> {
            for (int i = 0; i < ss.size(); i++) {
                ss.set(i, ss.get(i).toLowerCase());
            }
        });
        String[] lista = new String[] {"Ana", "Ion"};
        List<String> listb = Arrays.asList(lista);

        for (String s : lista)
            System.out.print(s+",");
        for (String s : listb)
            System.out.print(s+",");
        System.out.println();
        upper.convert(lista);
        upper2.convert(listb);
        for (String s : lista)
            System.out.print(s+",");
        for (String s : listb)
            System.out.print(s+",");
        System.out.println();
        lower.convert(lista);
        for (String s : lista)
            System.out.print(s+",");
        System.out.println();
    }
    public static void ex2(){
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
        ex();
        ex2();
        A mul = (a, b) -> a * b;
        A dif = new A() {
            @Override
            public int method(int a, int b) {
                return a - b;
            }
        };
        A sum = new Sum();
        System.out.println(mul.method(10, 20));
        System.out.println(dif.method(10, 20));
        System.out.println(sum.method(10, 20));
    }
}
