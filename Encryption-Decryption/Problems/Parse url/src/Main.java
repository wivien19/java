import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String myLink = sc.nextLine();
        String[] longKeys = myLink.split("\\?");
        String[] myKeys = longKeys[1].split("&");
        String[] myRealKeys = new String[myKeys.length+1];
        boolean value = false;
        
        for (int i = 0; i < myKeys.length; i++){
            if (myKeys[i].endsWith("=")){
                myRealKeys[i] = myKeys[i].replace("=", " : not found");
            }
            else
            myRealKeys[i] = myKeys[i].replace("=", " : ");
            if (myRealKeys[i].contains("pass")){
                value = true;
                myRealKeys[myKeys.length] = myRealKeys[i].replace("pass", "password");
            }
        }
        if (value){
            for (int i = 0; i < myRealKeys.length; i++){
                System.out.println(myRealKeys[i]);
            }
        }
        else {
            for (int i = 0; i < myRealKeys.length-1; i++){
                System.out.println(myRealKeys[i]);
            }
        }



    }
}