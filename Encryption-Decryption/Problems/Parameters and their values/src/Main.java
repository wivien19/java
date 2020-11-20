class Problem {

    public static void main(String[] args) {
        // Write your code here
        for (int i = 0; i < args.length; i++){
            if (i % 2 == 0){
                System.out.print(args[i] + "=");
            }
            else System.out.println(args[i]);
        }
    }
}