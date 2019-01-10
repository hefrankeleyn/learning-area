import java.math.BigInteger;
import java.util.Scanner;

public class LotteryOdds{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("How many numbers do you need to draw?");
        int k = in.nextInt();

        System.out.println("What is the highest number you can draw?");
        int n = in.nextInt();

        /*
         * Compute binomial coefficient 
        */
        //int lotteryOdds = 1;
        BigInteger lotteryOdds = BigInteger.valueOf(1);
        for(int i=1; i<=k; i++){
            //lotteryOdds = lotteryOdds*(n-i+1)/i;
            lotteryOdds = lotteryOdds.multiply(BigInteger.valueOf(n-i+1)).divide(BigInteger.valueOf(i));
        }
        System.out.println("Your odds are 1 in "+ lotteryOdds + ".Good luck");
        
        System.out.println((50*49*48*47*46*45L));
        System.out.println((50*49*48*47*46*45L)/(1*2*3*4*5*6));
    }
}