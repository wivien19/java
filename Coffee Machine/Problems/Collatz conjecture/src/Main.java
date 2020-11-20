import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int myNumber = sc.nextInt();
        double endNum = 0;
        while (myNumber != 1){
            System.out.print(myNumber + " ");
            if (myNumber % 2 == 1){
                myNumber = myNumber * 3 + 1;
            }
            else myNumber= myNumber / 2;

        }
        System.out.println(myNumber);


    }
}