import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        if (Math.abs(x1) == Math.abs(x2)) System.out.println("YES");
        else if (Math.abs(y1) == Math.abs(y2)) System.out.println("YES");
        else if ((Math.abs(y1)== Math.abs(y2+1) || y1 == Math.abs(y2-1)) && (x1 == x2+1 || x1 == x2-1))
            System.out.println("YES");
        else if ((Math.abs(y1)== Math.abs(y2+2) || y1 == Math.abs(y2-2)) && (x1 == x2+2 || x1 == x2-2))
            System.out.println("YES");
        else if ((Math.abs(y1)== Math.abs(y2+3) || y1 == Math.abs(y2-3)) && (x1 == x2+3 || x1 == x2-3))
            System.out.println("YES");
        else if ((Math.abs(y1)== Math.abs(y2+4) || y1 == Math.abs(y2-4)) && (x1 == x2+4 || x1 == x2-4))
            System.out.println("YES");
        else System.out.println("NO");
    }
}