package main.java.w3resource.indexInterface.p7;

public interface Sortable {
    default int[] clone(int[] array){
        if(array == null) return null;
        int[] res = new int[array.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = array[i];
        }
        return res;
    }
    int[] sort(int[] array);
}
