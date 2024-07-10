package w3resource.collections;

import javax.print.DocFlavor;
import java.util.*;

import static collection.list.Helper.contain;
import static collection.list.Helper.dublicate;

    public class AList<T> implements Comparator<T>{
        protected ArrayList<T> list = new ArrayList<>();

        public void  show(){

            for (int i = 0; i < list.size(); i++) {
                System.out.println(i + ":" + list.get(i).toString());
            }
        } //p1
        public Iterator<T>  iterator(){return list.iterator();} //p2
        public void  unshift(T value){
            list.add(0, value);
        } //p3
        public T get(int index){
            return list.get(index);
        } //p4
        public void update(int index, T value){list.set(index, value);} //p5
        public T remove(int index){return list.remove(index);} //p7
        public void sort(Comparator<T> c){
            Collections.sort(list, c);
        } //p8
        public void sort(){
            sort(this);
        } //p8
        public List<T> cloneList(){
            return (List<T>) list.clone();
        } //p9

        public List<T> shuffle(){
            var list = cloneList();
            Collections.shuffle(list);
            return list;
        } //p10

        public static void main(String[] args) {
        AList<String> colors = new AList<>();
        colors.unshift("Red");
        colors.unshift("Blue");
        colors.unshift("Green");
        colors.unshift("White");
        colors.remove(3);

        var it =colors.iterator();
        while (it.hasNext())
            System.out.println(it.next());
    }

        @Override
        public int compare(T o1, T o2) {
            return o1.hashCode() - o2.hashCode();
        }


    }
