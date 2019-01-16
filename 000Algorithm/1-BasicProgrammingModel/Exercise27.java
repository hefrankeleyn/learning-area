public class Exercise27{

    public static int count = 0;

    public static void main(String[] args) {
        //binomial(100, 50, 0.5);
        /*
        double result = binomial(10,5,0.5);
        System.out.println(result);
        System.out.println(count);
        */
        //double result = binomial(4,2,0.5);
        //System.out.println(count);
        /*
        double result = binomial(4,2,0.5);
        double result02 = binomial02(4,2,0.5);
        double r= 6*Math.pow(0.5,2)*Math.pow(0.5,2);
        System.out.println(result);
        System.out.println(result02);
        System.out.println(r);
        */

        // double r = Math.pow(2,50)*Math.pow(2,50);
        // System.out.println(r);
       //double a1=  Math.pow(0.5,-3);
       //System.out.println(a1);
       int[][] b = new int[11][6];
       printArray(b);
    }

    private static void printArray(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.printf("%9s","b["+i+"]["+j+"]");
            }
            System.out.println();
        }
    }
    /** 
     * C(N,k) = C(N-1,k-1)+C(N-1,k)
     * C(N,N) = 1;
     * C(0,k) = 0;
     * C(N,0) = 1;
     */
    public static double binomial(int N, int k, double p){
        count ++;
        if(N==0 && k==0){
            return 1.0;
        }
        if(N<0 || k<0){
            return 0.0;
        }
        return (1.0-p)*binomial(N-1, k, p) + p*binomial(N-1, k-1, p);
    }

    public static double binomial02(int N, int k, double p){
        double[][] b =new double[N+1][k+1];
        for(int i=0;i<=N;i++){
            b[i][0] = Math.pow(1.0-p, i);
        }

        for(int i=1; i<=N; i++){
            for(int j=1; j<=k; j++ ){
                b[i][j] = p*b[i-1][j-1] + (1.0-p) * b[i-1][j];
            }
        }
        return b[N][k];
    }
}