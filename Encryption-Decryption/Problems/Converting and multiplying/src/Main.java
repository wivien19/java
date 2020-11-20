import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String myLittleString = "";
        int myValue;
        while (sc.hasNextLine()){
        try {


                myLittleString = sc.nextLine();
                myValue = Integer.parseInt(myLittleString);
                if (myValue == 0) break;
                System.out.println(myValue * 10);

        }
        catch (Exception e){
            System.out.println("Invalid user input: " + myLittleString);
        }
    }
    }
}