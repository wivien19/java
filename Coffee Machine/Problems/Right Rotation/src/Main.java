import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String[] myArray = sc.nextLine().split(" ");
        int position = sc.nextInt();
        String val;
        String[] newArray = new String[myArray.length];

        if (position > myArray.length){
            while ( position > myArray.length)
            position -=myArray.length;
        }
        int b = position;
        for (int i = 0; i < position; i++){
            /*val = myArray[myArray.length - position + i];
            myArray[myArray.length - position + i] = myArray[i];
            myArray[i] = val;*/
            newArray[i] = myArray[myArray.length-b];
            b--;
        }
        int a = 0;
        for (int i = position; a < myArray.length -position; i++){
           /* val = myArray[myArray.length-a];
            myArray[myArray.length - a] = myArray[i];
            myArray[i] = val;
            a++;*/
            newArray[i] = myArray[a];
            a++;

        }
        for (int i = 0; i < myArray.length; i++){
            System.out.print(newArray[i] + " ");
        }

    }
}