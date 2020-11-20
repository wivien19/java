import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(Math.abs(j-i) + " ");
            }
            System.out.println();
        }
    }
}