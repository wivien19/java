import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int allNote = sc.nextInt();
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int dontknow = 0;
        for (int i = 0; i < allNote; i++){
           dontknow = sc.nextInt();
            switch (dontknow){
                case 2:
                    d++;
                    break;
                case 3:
                    c++;
                    break;
                case 4:
                    b++;
                    break;
                case 5:
                    a++;
                    break;
            }
        }
        System.out.println(d + " " + c + " " + b + " " + a);
    }
}