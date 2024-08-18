package sir;

public class SIr {
    //HW din sir de tip int  (4) {scaner}
    //printati prime jumater din sir 0-2
    //printati a doua jumater din sir 3-6
    //cel mai mare
    //
    public static <T> String toString(T[] mat){
        String res = "";
        if(mat == null)
            return "(null)";
        for (T anInt : mat) {
                res += (anInt + ",\t");
        }
        if(res.length() > 3)
            return res.substring(0, res.length() - 2);
        else
            return res;
    }
    public static String toString(byte[] mat){
        String res = "";
        if(mat == null)
            return "(null)";
        for (byte anInt : mat) {
            res += (anInt + ",\t");
        }
        if(res.length() > 3)
            return res.substring(0, res.length() - 2);
        else
            return res;
    }
    public static String toString(short[] mat){
        String res = "";
        if(mat == null)
            return "(null)";
        for (short anInt : mat) {
            res += (anInt + ",\t");
        }
        if(res.length() > 3)
            return res.substring(0, res.length() - 2);
        else
            return res;
    }
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
    public static String toString(long[] mat){
        String res = "";
        if(mat == null)
            return "(null)";
        for (long anInt : mat) {
            res += (anInt + ",\t");
        }
        if(res.length() > 3)
            return res.substring(0, res.length() - 2);
        else
            return res;
    }
    public static String toString(float[] mat){
        String res = "";
        if(mat == null)
            return "(null)";
        for (float anInt : mat) {
            res += (anInt + ",\t");
        }
        if(res.length() > 3)
            return res.substring(0, res.length() - 2);
        else
            return res;
    }
    public static String toString(double[] mat){
        String res = "";
        if(mat == null)
            return "(null)";
        for (double anInt : mat) {
            res += (anInt + ",\t");
        }
        if(res.length() > 3)
            return res.substring(0, res.length() - 2);
        else
            return res;
    }
    public static String toString(boolean[] mat){
        String res = "";
        if(mat == null)
            return "(null)";
        for (boolean anInt : mat) {
            res += (anInt + ",\t");
        }
        if(res.length() > 3)
            return res.substring(0, res.length() - 2);
        else
            return res;
    }
    public static String toString(char[] mat){
        String res = "";
        if(mat == null)
            return "(null)";
        for (char anInt : mat) {
            res += (anInt + ",\t");
        }
        if(res.length() > 3)
            return res.substring(0, res.length() - 2);
        else
            return res;
    }
    public interface Show<T> {
        String toShow(T arg);
    }
    public static <T> String toString(T[] mat, Show<T> show){
        String res = "";
        if(mat == null)
            return "(null)";
        for (T anInt : mat) {
            res += show.toShow(anInt);
        }
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
