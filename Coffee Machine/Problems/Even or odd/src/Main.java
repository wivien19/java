import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        int myNumber = 1;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            myNumber = sc.nextInt();
            if (myNumber == 0) break;
            else if (myNumber % 2 == 0) System.out.println("even");
            else System.out.println("odd");
        }
    }
}