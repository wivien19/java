import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        double m = sc.nextDouble();
        double p = sc.nextDouble();
        double k = sc.nextInt();
        int num = 0;


       /* for (double i = m; m < k; i++){

        }*/
        while (m < k){
            m = m + m * p / 100;

            num++;
        }
        System.out.println(num);
    }
}