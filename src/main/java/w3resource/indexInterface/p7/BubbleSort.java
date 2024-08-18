package main.java.w3resource.indexInterface.p7;

public class BubbleSort implements Sortable{
    @Override
    public int[] sort(int[] array) {
        int[] res =  clone(array);
        int tmp;
        for (int i = 0; i < res.length; i++) {
            for (int j = i + 1; j < res.length; j++) {
                if(res[i] > res[j])
                {
                    tmp = res[i];
                    res[i] = res[j];
                    res[j] = tmp;
                }
            }
        }
        return res;
    }
}
