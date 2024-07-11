package collection.list;

import homework.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class AList {
    public void creat(){
      ArrayList<String> list = new ArrayList<>();
      LinkedList<String> llist =  new LinkedList<>();
      list.add("Vasea");
      llist.add("A");
      list.add("Petru");
      list.add("Emil");
      list.add("Jhon");
      list.add("Sergiu");
      list.add("Petru");

        System.out.println("----------------------");
      System.out.println(list.get(0));
        System.out.println("----------------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("----------------------");
        Iterator<String> itn = list.iterator();
        while (itn.hasNext()){
            System.out.println(itn.next());
        }
    }
    public void ex(){
        ArrayList<Student> arrayList = new ArrayList<>();
        arrayList.add(new Student("Abram", "GA", 10));
        arrayList.add(new Student("Ben", "GA", 10));
        arrayList.add(new Student("Zara", "GB", 10));
        arrayList.add(new Student("Simon", "GB", 10));
        arrayList.add(new Student("Cross", "GC", 10));
        for (int i = 0; i < 3; i++) {
            System.out.println(arrayList.get(i).getName());
        }
    }
}
