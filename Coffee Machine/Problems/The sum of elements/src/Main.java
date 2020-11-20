import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        int myNum;
        while (sc.hasNextInt()){
            myNum = sc.nextInt();
            if (myNum == 0) break;
            else sum += myNum;
        }
        System.out.println(sum);
    }
}