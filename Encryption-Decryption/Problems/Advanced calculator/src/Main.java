/* Please, do not rename it */
class Problem {

    public static void main(String[] args) {
        String operator = args[0];
        // write your code here
        int[] myArray = new int[args.length-1];
        for (int i = 0; i < args.length-1; i++){
            myArray[i] = Integer.parseInt(args[i+1]);
        }
        switch (operator){
            case "MAX" :
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < myArray.length; i++){
                    if (myArray[i] > max){
                        max = myArray[i];
                    }
                }
                System.out.println(max);
                break;
            case "MIN" :
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < myArray.length; i++){
                    if (myArray[i] < min){
                        min = myArray[i];
                    }
                }
                System.out.println(min);
                break;
            case "SUM" :
                int sum = 0;
                for (int i = 0; i < myArray.length; i++){

                        sum += myArray[i];
                    }
                System.out.println(sum);
                break;

                }

    }
}