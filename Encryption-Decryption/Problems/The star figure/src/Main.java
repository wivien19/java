import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] array = new String[n][n];

        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= n; j++){
                if (n % 2 == 0){
                    if (n / 2 - 1 == i || n / 2 -1 == j)
                        System.out.print("*");
                    else if (j % 2 == 0 && i % 2 == 0) System.out.print("*");
                  //  else if (j % 2 == 0 && i == 0) System.out.print("*");
                   // else if (j % 2 == 0 && i == n-1) System.out.print("*");
                    else System.out.print(".");
                }

                else
                System.out.print(".");
            }
            System.out.println();
        }
    }
}