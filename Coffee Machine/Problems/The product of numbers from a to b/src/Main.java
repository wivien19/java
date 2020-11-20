import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int startNumber = sc.nextInt();
        int endNumber = sc.nextInt();
        long sum = 1;
        for (int i = startNumber; i < endNumber; i++){
            sum *= i;
        }
        System.out.println(sum);
    }
}