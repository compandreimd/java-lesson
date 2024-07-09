package collection.list;

import org.jetbrains.annotations.Contract;

import java.util.List;

public class Helper {
    @Contract(pure = true)
    public static <T> boolean contain(List<T> list, T s){
        for (T f : list){
            if(f.equals(s)) return true;
        }
        return false;
    }
    public static <T> boolean dublicate(List<T> list, T s){
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if(list.get(i).equals(list.get(j))) return  true;
            }
        }
        return false;
    }
    public interface  IEqualAction<T>{
        boolean myEqual(T a, T b);
    }
    public static <T> boolean contain(List<T> list, T s, IEqualAction<T> equalAction){
        for (T f : list){
            if(equalAction.myEqual(f,s)) return true;
        }
        return false;
    }
    public static <T> boolean dublicates(List<T> list, T s, IEqualAction<T> equalAction){
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if(equalAction.myEqual(list.get(i), list.get(j))) return  true;
            }
        }
        return false;
    }
}
