import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        String num = scanner.nextLine();
        char[] nums = num.toCharArray();
        if (nums[2] == '0'){
            System.out.print(nums[1]);
            System.out.print(nums[0]);
        }
        else {
            System.out.print(nums[2]);
            System.out.print(nums[1]);
            System.out.print(nums[0]);
        }

    }
}