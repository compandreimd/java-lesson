package sir;

public class Sir2D {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        int[][] b = {
                {3, 4, 5, 6},
                {7, 8, 9, 10},
                {11, 12, 13, 14},
                {15, 16, 17, 18}};
        for(int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.print(b[i][j] + ",\t");
            }
            System.out.println("");
        }
        System.out.print("Diagonal:");
        for (int i = 0; i < b.length && i < b[i].length; i++) {
            System.out.print(b[i][i]+",\t");
        }
        if(b.length >= 2) {
            System.out.print("\r\nAl 2 rand:");
            for (int i = 0; i < b[1].length; i++) {
                System.out.print(b[1][i] + ",\t");
            }
            System.out.print("\r\nAl 2 rand desc:");
            for (int i = b[1].length - 1; i >= 0; i--) {
                System.out.print(b[1][i] + ",\t");
            }
        }
        System.out.println("\r\nPrint desc:");
        for(int i = b.length - 1; i >= 0; i--) {
            for (int j = b[i].length -1; j >= 0; j--) {
                System.out.print(b[i][j] + ",\t");
            }
            System.out.println("");
        }

        //Diagonal inv [19,13]
        System.out.print("Diagonal_inv :");
        for (int i = b.length - 1; i >= 0; i--) {
            System.out.print(b[i][i]+",\t");
        }
        System.out.println();
        System.out.print("Diagonal2    :");
        for (int i = b.length - 1; i >= 0; i--) {
            if(i >= b[i].length) break;
            System.out.print(b[b.length - i - 1][i]+", ");
        }
        System.out.println();
        System.out.print("Diagonal2_inv:");
        for (int i = b.length - 1; i >= 0; i--) {
            if(i >= b[i].length) break;
            System.out.print(b[i][b.length - i - 1]+", ");
        }
        System.out.println();
        System.out.println("r_c_c_d:");
        for(int i = 0; i < b.length; i++) {
            for (int j = b[i].length - 1; j >= 0 ; j--) {
                System.out.print(b[i][j] + ",\t");
            }
            System.out.println("");
        }
        System.out.println("r_d_c_c:");
        for(int i = b.length - 1; i >= 0; i--) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.print(b[i][j] + ",\t");
            }
            System.out.println("");
        }
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
