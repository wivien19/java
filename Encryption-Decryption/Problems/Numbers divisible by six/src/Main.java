import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int myNumber;
        int sum = 0;
       for (int i = 0; i < input; i++){
            myNumber = sc.nextInt();
            if (myNumber % 6 == 0){
                sum += myNumber;
            }
        }
        System.out.println(sum);
    }
}