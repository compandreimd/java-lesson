package w3resource.indexInterface;

import sir.SIr;

import w3resource.indexInterface.p11.MergeSort;
import w3resource.indexInterface.p7.BubbleSort;
import w3resource.indexInterface.p7.SelectionSort;
import w3resource.indexInterface.p7.Sortable;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import java.util.Timer;

public class Test {

    public static void main(String[] args) throws InvalidAlgorithmParameterException, NoSuchPaddingException, UnsupportedEncodingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {
        int [] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.round(Math.random()* 1000);
        }

        System.out.println("List:"+SIr.toString(arr));
        Sortable sortables[] = {
                new BubbleSort(),
                new SelectionSort(),
                new MergeSort(),
                new SelectionSort()
        };
        Timer t = new Timer();
        for (Sortable sortable: sortables) {
            long startTime = System.nanoTime();
            int sortarr[] =  sortable.sort(arr);
            long endtime = System.nanoTime();
            System.out.println("Sort ("+(endtime - startTime)+")");//+SIr.toString(sortable.sort(arr)));

        }

    }
}