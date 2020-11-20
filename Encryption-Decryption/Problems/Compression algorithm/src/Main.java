import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        char c = line.charAt(0);
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == c) {
                count++;
            } else {
                System.out.print(c);
                System.out.print(count);
                c = line.charAt(i);
                count = 1;
            }
        }
        System.out.print(c);
        System.out.print(count);
    }
}