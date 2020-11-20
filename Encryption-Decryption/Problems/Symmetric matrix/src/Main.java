import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        boolean value = true;
        int[][] matrix = new int [size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                matrix[i][j] = sc.nextInt();
               // System.out.print(matrix[i][j]);
            }
           // System.out.println();
        }
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                if (matrix[i][j] != matrix[j][i]){
                   // System.out.println("YES");
                    value = false;
                }

            }

        }
        if (value) System.out.println("YES");
        else System.out.println("NO");
    }
}