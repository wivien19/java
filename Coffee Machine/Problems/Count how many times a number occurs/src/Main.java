import java.lang.reflect.Array;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int arrayLength = sc.nextInt();
        int counter = 0;
        int[] array = new int [arrayLength];
        for (int i = 0; i < arrayLength; i++){
            array[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        for (int i = 0; i < array.length; i++){
            if (array[i] == n){
                counter++;
            }
        }
        System.out.println(counter);
    }
}