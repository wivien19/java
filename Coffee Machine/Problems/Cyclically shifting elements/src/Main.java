import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int input = scanner.nextInt();
        int[] a = new int[input];
        int[] c = new int[input];
        for (int i = 0; i < input; i++){
            a[i] = scanner.nextInt();
        }

            int var = a[a.length-1];
            int var0 = a[0];
            int b = 1;
            for (int i = 0; i < a.length-1; i++){
                c[b] = a[i];
                b++;
            }
           // a[a.length-1] = a[0];
            c[0] = var;



        for (int i = 0; i < a.length; i++){
            System.out.print(c[i] + " ");
        }

    }
}