import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        double sum = 0;
        double piece = 0;
        double avarage;

        for (int i = a; i <= b; i++) {
            if (i % 3 == 0) {
                sum += i;
                piece++;
            }
        }

        avarage = sum / piece;
        System.out.println(avarage);
    }
}