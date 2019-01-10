public class BasicProgrammingModelExercises{
    public static void main(String[] args) {
        //System.out.println("**1.1 ");
        //BasicProgrammingModelExercises.exercise01();
        //System.out.println("**1.2 ");
        //BasicProgrammingModelExercises.exercise02();
        //System.out.println("**1.5 ");
        //BasicProgrammingModelExercises.exercise05();
        //System.out.println("**1.7 ");
        //BasicProgrammingModelExercises.exercise07();
        //System.out.println("**1.7_2 ");
        //BasicProgrammingModelExercises.exercise07_2();
        //System.out.println("**1.8 ");
        //BasicProgrammingModelExercises.exercise08();
        //System.out.println("**1.9 ");
        //BasicProgrammingModelExercises.exercise09();
        //System.out.println("**1.11 ");
        Boolean[][] twoDim = {
                              {true,true,false},
                              {true,false,true},
                              {false,true,true}
                             };
        //BasicProgrammingModelExercises.exercise11(twoDim);
        //BasicProgrammingModelExercises.exercise13(twoDim);
        //int r = BasicProgrammingModelExercises.exercise14(33);
        //System.out.println(r);
        /*
        int[] a = { 1, 2, 3, 3, 3, 2, 2, 1, 4, 5, 4, 8};
        int M=9;
        int[] ra=BasicProgrammingModelExercises.histogram(a, M);
        int sum=0;
        for(int i=0;i<ra.length;i++){
            //System.out.print(ra[i]);
            sum+=ra[i];
        }
        */
        //System.out.println();
        //System.out.println(a.length+","+sum);
        //System.out.println();
        //System.out.println(exercise16(6));
        //System.out.println("**1.18 ");
        //System.out.println(exercise18(2,25));
        //System.out.println(exercise18(3,11));
        System.out.println("**1.19 ");
        int res =0;
        for(int N=0;N<100;N++){
            long st = System.currentTimeMillis();
            System.out.println(N+" "+F(N));
            long et = System.currentTimeMillis();
            long cha = et-st;
            System.out.println(cha);
            //long largestT = 1*60*60*1000;
            long largestT = 1*60*1000;
            if(cha>largestT){
                System.out.println(largestT+" "+cha);
                break;
            }
            res=N;
        }
        System.out.println(res);
    }
    private static long F(int N){
        if(N==0) return 0;
        if(N==1) return 1;
        return F(N-1) + F(N-2);
    }
    private static int exercise18(int a,int b){
        if(b == 0) return 0;
        if(b%2 ==0) return exercise18(a+a,b/2);
        return exercise18(a+a,b/2)+a;
    }
    private static String exercise16(int n){
        if(n<=0) return "";
        return exercise16(n-3)+n+exercise16(n-2)+n;
    }
    private static int[] histogram(int[] a,int M){
        int[] ra = new int[M];
        for(int i=0;i<M;i++){
            int count=0;
            for(int j=0;j<a.length;j++){
                if(i==a[j]){
                    count++;
                }
            }
            ra[i]=count;
        }
        return ra;
    }
    private static int exercise14(int N){
        int r =1;
        int con=0;
        while(r*2<N){
            r*=2;
            con++;
        }
        return con;
    }
    private static void exercise13(Object[][] twoDim){
        for(int i=0;i<twoDim.length;i++){
            for(int j=0;j<twoDim[i].length;j++){
                System.out.print(twoDim[j][i]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    private static void exercise11(boolean[][] twoDim){
        for(int i=0;i<twoDim.length;i++){
            for(int j=0;j<twoDim[i].length;j++){
                if(twoDim[i][j]){
                    //System.out.print("*");
                    System.out.format("[%d,%d]:*", i,j);
                }else{
                    //System.out.print(" ");
                    System.out.format("[%d,%d]: ",i,j);
                }
                //System.out.print("("+i+","+j+")");
            }
            System.out.println();
        }
    }
    private static void exercise09(){
        String bs = Integer.toBinaryString(6);
        System.out.println(toBinStr(6));
        System.out.println(bs);
    }
    public static String toBinStr(int N){
        String bs = "";
        for(int n=N;n>0;n /=2){
            bs = (n%2) +bs;
        }
        return bs;
    }
    public static String toBinStr02(int N){
        String bs ="";
        int n=1;
        //计算 第一个参数的值提升到第二个参数的次幂
        while(Math.pow(2, n)<=N){
            n++;
        }
        int[] binary = new int[n];
        for(int i=n-1;i>=0;i--){
            binary[i]=N%2;
            N /=2;
        }
        for(int i=0;i<n;i++){
            bs += ""+binary[i];
        }
        return bs;
    }
    private static void exercise08(){
        System.out.println('b');
        System.out.println('b'+'c');
        System.out.println((char)('a'+4));
    }
    private static void exercise07_2(){
        int sum =0;
        for(int i=1;i<1000;i*=2){
            for(int j=0;j<1000;j++){
                sum++;
            }
            System.out.println("i:"+i+" ,"+sum);
        }
        System.out.println("result:"+sum);

    }

    private static void exercise01(){
        System.out.println((0+15)/2);
        System.out.println(2.0e-3);
        System.out.println(2.0e-6);
        System.out.println(2.0e-6*100000000.1);
        System.out.println(true&&false||true&&true);
    }
    private static void exercise02(){
        System.out.println((1+2.236)/2);
        System.out.println(1+2+3+4.0);
        System.out.println(4.1>=4);
        System.out.println(1+2+"3");
    }

    private static void exercise03(String[] args){
        try{

            int one = Integer.parseInt(args[0]);
            int two = Integer.parseInt(args[1]);
            int three = Integer.parseInt(args[2]);
            if(one==two && two==three){
                System.out.println("equal");
            }else{
                System.out.println("not equal");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    private static void exercise04(double x,double y){
        if((x>0.0 && x<1.0) && (y>0.0 && y<1.0)){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
    private static void exercise05(){
        int a= Math.abs(20);
        System.out.println(a);
    }
    private static void exercise07(){
        double t =9.0;
        while(Math.abs(t-9.0/t)>0.001){
            System.out.println(t-9.0/t);
            System.out.println(t);
            t = (9.0/t+t)/2.0;
            System.out.println(t);
        }
        System.out.printf("%.5f\n", t);
    }
}