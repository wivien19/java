import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String myString = sc.nextLine();
        char[] myArray = myString.toCharArray();
        if (myArray[0] + myArray[1] + myArray[2] == myArray[4] + myArray[5] + myArray[3]){
            System.out.println("Lucky");
        }
        else {
            System.out.println("Regular");
        }
    }
}