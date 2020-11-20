import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        int var = Integer.MIN_VALUE;
        int neededRow = 0;
        int neededColumn = 0;
        int[][] myArray = new int[row][column];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                myArray[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                if (myArray[i][j] > var){
                    var = myArray[i][j];
                    neededColumn = j;
                    neededRow = i;
                }
            }
        }
       /* for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                System.out.print(myArray[i][j] + " ");
            }
            System.out.println();
        }*/
        System.out.println(neededRow + " " + neededColumn);
    }
}