import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if(a < 1) System.out.println("no army");
        else if (a >= 1 && a < 20) System.out.println("pack");
        else if (a >= 20 && a < 250) System.out.println("throng");
        else if (a >= 250 && a < 1000) System.out.println("zounds");
        else if (a >= 1000) System.out.println("legion");
    }
}