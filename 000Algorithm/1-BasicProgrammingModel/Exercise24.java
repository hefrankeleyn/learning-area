public class Exercise24{
    public static void main(String[] args) {
        //int result = Euclid(23, 8);
        int result = Euclid(1111111, 1234567);
        //int result = Euclid(8, 24);
        System.out.println("result: "+result);
    }
    private static int Euclid(int a, int b){
        System.out.println(a+", "+b);
        if(b == 0) return a;
        int r = a % b;
        return Euclid(b,r);
    }
}