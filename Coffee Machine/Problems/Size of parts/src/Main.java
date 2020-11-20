import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int[] myArray = new int[input];
        int nullCounter = 0;
        int plusCounter = 0;
        int minusCounter = 0;
        for (int i = 0; i < input; i++){
            myArray[i]= sc.nextInt();
        }
        for (int i = 0; i < myArray.length; i++){
            if (myArray[i] == 0){
                nullCounter++;
            }
            else if (myArray[i] == 1){
                plusCounter++;
            }
            else {
                minusCounter++;
            }
        }
        System.out.println(nullCounter + " " + plusCounter + " " + minusCounter);
    }
}