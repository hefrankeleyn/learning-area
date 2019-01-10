public class DataType{
    public static void main(String[] args) {
        //DataType.byteTypeTest();
        //doubleTypeTest();
        //doubleTypeTest02();
        //floatTypeTest();
        //System.out.println(Math.pow(2, 16));
        //floorModTest();
        //bitTest();
        //joinTest();
        //compareStrTest();
        //exercise20(3);
        //double rl = Math.log10(exercise20(3));
        //System.out.println(rl);
        //System.out.println(Math.log10(2));
        //exercise21(args);
    }
    

    private static void exercise21(String[] args){
        while(!StdIn.isEmpty()){
            //String line = StdIn.readLine();
            String name = StdIn.readString();
            float firstInt = StdIn.readInt();
            float secondInt = StdIn.readFloat();
            System.out.println(name+"\t"+firstInt+"\t"+secondInt);
           //String[] as = line.split(" ");
           //StdOut.printf("%s\t", name);
           //StdOut.printf("%3d\n", firstInt);
           //StdOut.printf("%3d\n", secondInt);
           StdOut.printf("%s\t%.3f\t%.3f\t%.3f\n", name,firstInt,secondInt,firstInt/secondInt);
        }
    }
    // https://binism.github.io/blog/2016/07/04/Algorithm-with-Java-ch1ans/
    private static double lnPro(int N){
        if (N == 1) return 0;
        if (N == 2) return 1;
        return Math.log(N) + lnPro(N-1);
    }

    private static double exercise20(int N){
        if(N==1)  return 1;
        else return N*exercise20(N-1);
    }
    private static void compareStrTest(){
        String s="hello";
        String t= "hello";
        int e = s.substring(3).compareTo(t.substring(3));
        System.out.println(s==t);
        System.out.println(s.equals(t));
        System.out.println(e);
    }
    private static void joinTest(){
        String s1 = "aaa";
        String s2 = "bbb";
        String s3 = "ccc";
        String[] sa = {s1,s2,s3};
        String rs = String.join(",", sa);
        System.out.println(rs);
    }
    private static void bitTest(){
        int bit01 = 1<<35;
        int bit02 = 1<<3;
        int bit03 = 1<<8;
        System.out.println(bit01);
        System.out.println(bit02);
        System.out.println(bit03);
    }
    private static void floorModTest(){
        int res = Math.floorMod(13, 12);
       // int res = Math.floorMod(-13, 12);
        System.out.println(res);
    }
    private static void floatTypeTest(){
        float f = 3.124E+2F;
        System.out.println(f);
    }
    private static void byteTypeTest(){
        byte b1 = 127;
        b1++;
        System.out.println(b1);
    }
    private static void doubleTypeTest02(){
        String a="aa";
        double d=23.0;
        boolean re=Double.isNaN(d);
        System.out.println(re);
    }
    private static void doubleTypeTest(){
        //String a="";
        System.out.println(Double.NaN);
        Integer a =2;
        if(a == Double.NaN){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}