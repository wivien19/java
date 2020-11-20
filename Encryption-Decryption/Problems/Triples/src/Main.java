import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        int size;
        int counter = 0;
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++){
            array[i] = sc.nextInt();
        }
        for (int i = 1; i < array.length - 1; i++){
            if ((array[i] - 1 == array[i-1]) && (array[i] + 1 == array[i+1])){
                counter++;
            }
        }
        System.out.println(counter);
    }
}