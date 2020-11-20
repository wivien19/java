import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String myNum = scanner.nextLine();
        char[] littleArray = new char[4];
        char[] originalArray = myNum.toCharArray();
        for (int i = 0; i < originalArray.length; i++){
            littleArray[i] = originalArray[i];
        }
        if (originalArray.length < 4){
            for (int i = originalArray.length; i < 4; i++){
                littleArray[i] = '0';
            }
        }
       /* for (int i = 0; i < littleArray.length; i++){
            System.out.print(littleArray[i]);
        }*/
        if (littleArray[0] == littleArray[3] && littleArray[1] == littleArray[2]){
            System.out.println(1);
        }
        else {
            System.out.println(37);
        }
    }
}