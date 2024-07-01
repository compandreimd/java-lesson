package w3resource.indexInterface;

import sir.SIr;
import w3resource.indexInterface.p11.MergeSort;
import w3resource.indexInterface.p7.BubbleSort;
import w3resource.indexInterface.p7.SelectionSort;
import w3resource.indexInterface.p7.Sortable;

public class Test {

    public static void main(String[] args) {
        int [] arr = {
                2, 4, 2, 1 ,4, 5,
                34, 4, 5, 6, 2, 8, 9
        };
        System.out.println("List:"+SIr.toString(arr));
        Sortable sortables[] = {
                new BubbleSort(),
                new SelectionSort(),
                new MergeSort(),
                new SelectionSort()
        };
        for (Sortable sortable: sortables) {
            System.out.println("Sort:"+SIr.toString(sortable.sort(arr)));
        }
    }
}
