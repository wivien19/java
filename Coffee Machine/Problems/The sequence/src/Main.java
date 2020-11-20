import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        int max = 0;
        Scanner sc = new Scanner(System.in);
        int i=0;
        int num1;
        while (sc.hasNextInt()){
            num1 = sc.nextInt();
            if (num1%4 == 0 && num1 > max){
                max = num1;
            }
            i++;
        }
        System.out.println(max);
    }
}