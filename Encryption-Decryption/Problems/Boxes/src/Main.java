import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int z1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        int z2 = sc.nextInt();

        int[] arry = {x1, y1, z1};
        int[] arry2 = {x2, y2, z2};
        Arrays.sort(arry);
        Arrays.sort(arry2);

        if (x1 * y1 * z1 == x2 * y2 * z2){
            System.out.println("Box 1 = Box 2");
        }
        else {
            if (arry[0] <= arry2[0] && arry[1] <= arry2[1] && arry[2] <= arry2[2]) {
                System.out.println("Box 1 < Box 2");
            }
            else if (arry[0] >= arry2[0] && arry[1] >= arry2[1] && arry[2] >= arry2[2]) {
                System.out.println("Box 1 > Box 2");
            }
            else System.out.println("Incomparable");
        }

    }
}