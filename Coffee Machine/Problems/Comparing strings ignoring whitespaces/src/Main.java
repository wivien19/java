import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String elso = sc.nextLine();
        String masodik = sc.nextLine();
        System.out.println(elso.replace(" ", "").equals(masodik.replace(" ", "")));

    }
}