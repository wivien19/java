import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String myString = sc.nextLine();
        boolean value = true;
        char[] myArray = myString.toCharArray();
        for (int i = 0; i < myArray.length-1; i++){
            if ((myArray[i] != myArray[i+1] - 1)){
                value = false;
            }
        }
        if (value){
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
}
