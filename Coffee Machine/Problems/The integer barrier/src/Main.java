import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        int myNumber;
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()){
            myNumber = sc.nextInt();
            sum += myNumber;
            if (myNumber == 0){
                System.out.println(sum);
                break;
            }
            else if (sum >= 1000){
                System.out.println(sum - 1000);
                break;
            }
        }
    }
}