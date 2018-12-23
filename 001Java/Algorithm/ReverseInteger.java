public class ReverseInteger{

    public static void main(String[] args) {
        ReverseInteger rI = new ReverseInteger();
        //int x = 234;
        int x = 2147483647;
        System.out.println("x: "+x);
        System.out.println(Integer.MAX_VALUE+" , "+Integer.MIN_VALUE);
        int result = rI.solution(x);
        System.out.println("result: "+result);
    }

    private int solution(int x){
        boolean lowZero = false;
        String tempX = x + "";
        byte[] bA = tempX.getBytes();
        int index_i = 0;
        if (x<0){
            index_i=1;
        }
        for (int i=index_i,j=bA.length-1;i<j;i++,j--){
            byte tmp = bA[i];
            bA[i] = bA[j];
            bA[j] = tmp;
        }
        try{
            return Integer.parseInt(new String(bA));
        }catch(Exception e){
            return 0;
        }
    }
}