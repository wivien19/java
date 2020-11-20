import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        double a;
        double b;
        double c;
        switch (name){
            case "circle":
                double r = sc.nextInt();
                System.out.println(r * r * 3.14);
                break;
            case "rectangle":
                a = sc.nextInt();
                b = sc.nextInt();
                System.out.println(a * b);
                break;
            case "triangle":
                 a = sc.nextInt();
                 b = sc.nextInt();
                 c = sc.nextInt();
                 double s = (a + b + c) / 2;
                System.out.println(Math.sqrt((s-a)*(s-b)*(s-c)*s));
                break;

        }
    }
}