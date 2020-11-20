import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int next;
        while (sc.hasNextLine()){
            next = sc.nextInt();
            if (next > number){
                number = next;
            }
        }
        System.out.println(number);
    }
}