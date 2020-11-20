import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int firstNumber = sc.nextInt();
        int secondNumber = sc.nextInt();
        if (secondNumber == 0 || firstNumber == 0){
            System.out.println("true");
        }
        int nextNumber;
        while (sc.hasNextInt()){
            nextNumber = sc.nextInt();
            if (nextNumber == 0 || firstNumber == 0 || secondNumber == 0){
                System.out.println("true");
                break;
            }
            if (firstNumber > secondNumber){
                if (secondNumber < nextNumber){
                    System.out.println("false");
                    break;
                }
                else secondNumber = nextNumber;
            }
            else if (firstNumber < secondNumber){
                if (secondNumber > nextNumber){
                    System.out.println("false");
                    break;
                }
                else secondNumber = nextNumber;
            }
            secondNumber = nextNumber;

        }
       // System.out.println("true");
    }
}