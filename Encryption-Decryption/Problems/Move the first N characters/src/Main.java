import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String transform = sc.next();
        int width = sc.nextInt();
        char[] myArry = transform.toCharArray();
        char[] newArray = new char[myArry.length];
        int index = 0;

        if (myArry.length < width){
            for (int i = 0; i < myArry.length; i++){
                newArray[i] = myArry[i];
            }

        }
        else {
            for (int i = width; i < myArry.length; i++){
                newArray[index] = myArry[i];
                index++;
            }
            for (int i = 0; i < width; i++){
                newArray[index] = myArry[i];
                index++;
            }
        }


        for (int i = 0; i < newArray.length; i++){
            System.out.print(newArray[i]);
        }
    }
}