import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int [] array = new int [size];
        int min = 1000;
        for (int i = 0; i < size; i++){
            array[i] = sc.nextInt();
        }
        for (int i = 0; i < array.length; i++){
            if(array[i] < min){
                min=array[i];
            }
        }
        System.out.println(min);
    }
}