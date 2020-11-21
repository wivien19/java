class alga {
    //egy parameteres rekurziv
    //kapa: 4, csákány: 4, lapát:1

     public static int asas(int n){
        if (n == 1) return 1;
        if (n == 2) return 1;
        if (n == 3) return 1;
        if (n == 4) return 3;
        return asas(n-1)+2*asas(n-4);
    }
    //ket parameteres rekurziv
    public static int lepes(int n, int k){
        if (n == 1 || k == 1) return 1;
        return lepes(n-1,k)+lepes(n,k-1);
    }

    //ket parameteres dinamikus
    public static int lepes2(int k, int n){
         int[][] T = new int[k+1][n+1];
         for (int j = 1; j <=n; j++) T[1][j]=1;
         for (int i = 2; i <= k; i++) T[i][1] = 1;

         for (int i =2; i <= k; i++){
             for (int j = 2; j <= n; j++){
                 T[i][j] = T[i-1][j] + T[i][j-1];
             }
         }
         return T[k][n];
    }

    //egy parameteres dinamikus
    public static int lepcso(int n){
         int[] T = new int[n+1];
         T[1] = 1;
         T[2] = 2;
         for (int i = 3; i <= n; i++){
             T[i] = T[i-1] + T[i-2]; 
         }
         return T[n];
    }
    public static int[] mezo( int P [], int n , int F )
    {
        int t[]=new int[F +1 ];
        t[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = P[i]; j <= F; j++) {
                if (t[j+1] != -1){
                    t[j] += t[j-P[i]];
                    break;
                }
                if (t[i+1] != -1){
                    t[j] += t[j-P[i]];
                    break;
                }
                if (t[i+1+i*j] != -1){
                    t[j] += t[j-P[i]];
                }
            }

        }

        return t;
    }







    public static void main(String[] args) {

        System.out.println(asas(6)); //AAA, AB, BA, CA, AC
        System.out.println(lepes(2,2));
        /* X Y      W > X > Y
           W Z      W > Z > Y
         */
        System.out.println(lepes2(3,3));
        /*
            A B C       G > H > I > F > C           G > H > E > B > C
            D E F       G > H > E > F > C           G > D > A > B > C
            G H I       G > D > E > E > C           G > D > E > B > C
         */
        System.out.println(lepcso(4));


    }

}



