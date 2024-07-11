package collection.map;

import oop.access.D;
import org.jetbrains.annotations.NotNull;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class DemoMap {
    String name;
    static HashMap<DemoMap, Integer> dic = new HashMap<>();
    DemoMap(String name){
        this.name = name;
    }
    public static <K, V> @NotNull HashMap<K, V> clone(HashMap<K, V> map){
        HashMap<K, V> m =  new HashMap<>();
        for (var x : map.entrySet()){
            m.put(x.getKey(), x.getValue());
        }
        return m;
    }
    public static  <K, V> void change(@NotNull HashMap<K, V> dic, K key, V i){
        for (var set : dic.entrySet()){
            K k = set.getKey();
            if(k != null && k.equals(key))
                set.setValue(i);
        }
//        if(dic.containsKey(key)){
//            dic.put(key, i);
//        }
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {

        dic.put(new DemoMap("A"), 1);
        dic.put(new DemoMap("B"), 2);
        dic.put(new DemoMap("X"), 3);
        //dic.put("D", 4);
        DemoMap D = new DemoMap("D");
        dic.put(D, 5);
        dic.put(new DemoMap("Z"), 6);
        dic.put(new DemoMap("S"), 7);
        dic.put(null, 21);
        var b = clone(dic);
        change(dic, D, 10);
        System.out.println(dic);
        System.out.println(b);
//        for (Map.Entry<DemoMap, Integer> a : dic.entrySet()){
//            if(a.getKey() == null){
//                System.out.println("|<null>" + ":" + a.getValue());
//            }
//            else {
//                System.out.println("|" + a.getKey().name + ":" + a.getValue());
//            }
//        }
//        dic.forEach((s, a) -> {
//            if(s == null)
//                System.out.println("|<null>" + ":" + a);
//            else
//                System.out.println(s.name+":"+a);
//        });
    }
}
