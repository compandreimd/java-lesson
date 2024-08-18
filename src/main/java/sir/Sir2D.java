package sir;

public class Sir2D {
    public final static <T> void print(T[][] mat){
          if(mat == null)
              return;
        for (T[] ints : mat) {
            for (T anInt : ints) {
                System.out.print(anInt + ",\t");
            }
            System.out.println("");
        }
    }
    public final static <T> void print(int[][] mat){
        if(mat == null)
            return;
        for (int[] ints : mat) {
            for (int anInt : ints) {
                System.out.print(anInt + ",\t");
            }
            System.out.println("");
        }
    }
    public static int[] sizes(int[][] mat){
        if(mat ==  null ) return null;
        int sizes[] = new int[mat.length + 1];
        sizes[0] = mat.length;
        for (int i = 0; i < sizes[0]; i++) {
            sizes[1 + i] = mat[i].length;
        }
        return sizes;
    }

    public static int max(int[] mat){
        if(mat == null) return  0;
        int max  = mat[0];
        for (int x: mat) {
            if(max > x){
                max = x;
            }
        }
        return max;
    }
    public static int[] diag(int[][] mat, boolean inv, boolean first ){
        if(mat == null) return null;
        //System.out.print("Diagonal :");
        int size = max(sizes(mat));
        int dig[] =  new int[size];
        for (int i = 0; i < size; i++) {
            if(first){
                dig[i] = mat[i][i];
            }
            else {
                dig[i] = mat[i][size-i-1];
            }
        }
        if(inv){
            dig = inv(dig);
        }

        return dig;
    }
    public static int[] inv(int a[]){
        if(a == null) return  null;
        int size = a.length;
        int[] r = new int[size];
        for (int i = 0; i < size; i++) {
           r[i] = a[size - i - 1];
        }
        return r;
    }
    public static int[][] inv(int mat[][]){
        if(mat == null) return  null;
        int size = mat.length;
        int[][] r =  new int[size][0];
        for (int i = 0; i < size; i++) {
            r[i] = mat[size - i -1];
        }
        return r;
    }
    public static int[][] change(int mat[][], boolean inv_col, boolean inv_row){
        if(mat == null) return  null;
        int size = mat.length;
        int r[][] = new int[size][0];
        for (int i = 0; i < size; i++) {
            r[i] =  inv_col ? inv(mat[i]) : mat[i];
        }

        if(inv_row) r = inv(r);

        return r;
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[][] b = {
                {3, 4, 5, 6},
                {7, 8, 9, 10},
                {11, 12, 13, 14},
                {15, 16, 17, 18}};

        print(b);
        System.out.print("Diag1:");
        a = diag(b, false, true);
        print(new int[][]{a});
        System.out.print("Diag2:");
        a = diag(b, false, false);
        print(new int[][]{a});
        System.out.print("Diag1_inv:");
        a = diag(b, true, true);
        print(new int[][]{a});
        System.out.print("Diag2_inv:");
        a = diag(b, true, false);
        print(new int[][]{a});
        if(b.length >= 2) {
            System.out.print("Al 2 rand:");
            print(new int[][]{b[1]});
            System.out.print("Al 2 rand desc:");
            print(new int[][]{inv(b[1])});
        }
        System.out.println("Print desc:");
        print(change(b, true, true));
        System.out.println("r_c_c_d:");
        print(change(b, true, false));
        System.out.println("r_d_c_c:");
        print(change(b, false, true));
        System.out.print("custom1: ");
            for (int i = b.length - 1; i >= b.length - 2; i--) {
                for (int j = 0; j < b[i].length; j++) {
                    if(j >= b.length ) continue;
                    System.out.print(b[j][i] + ",\t");
                }
            }
        System.out.println();
        System.out.print("custom2: ");
              for (int i = b.length - 1; i >= 0; i--) {
                  for (int j = 1; j >= 0; j--) {
                      if(j >= b[i].length) continue;
                      System.out.print(b[i][j] + ",\t");
                  }
              }
        System.out.println();
    }






    //rand cres, col desc
    //rand desc, col cres
    //inv r -> c, c->r 6,10,14,18, 5, 9, 13,17 ... ultimele 2
    //inv r -> 16, 15, 12, 11, 8, 7
}
