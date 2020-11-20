import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int ev = sc.nextInt();
        if (ev % 4 == 0 && ev % 100 != 0 || ev % 400 == 0){
            System.out.println("Leap");
        }
        else {
            System.out.println("Regular");
        }
    }
}