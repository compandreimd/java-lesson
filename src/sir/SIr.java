package sir;

public class SIr {
    //HW din sir de tip int  (4) {scaner}
    //printati prime jumater din sir 0-2
    //printati a doua jumater din sir 3-6
    //cel mai mare
    //
    public static String toString(int[] mat){
        String res = "";
        if(mat == null)
            return "(null)";
        for (int anInt : mat) {
                res += (anInt + ",\t");
        }
        if(res.length() > 3)
            return res.substring(0, res.length() - 2);
        else
            return res;
    }
    public static void main(String[] args) {
        String s[] = {"1", "3", "2", "1", "4"};
        String s2[] = new String[5];
        s2[0] = "a";
        System.out.println(s[0]);
        for (int i = 0; i < 5 ; i++) {
            System.out.println(s[i]);
        }
    }


}
