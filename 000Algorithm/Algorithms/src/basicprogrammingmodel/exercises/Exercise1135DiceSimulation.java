package basicprogrammingmodel.exercises;

import java.util.Arrays;
import java.util.logging.Logger;

import utils.chapter1.StdRandom;

/**
 * 
 */
public class Exercise1135DiceSimulation {

    private static final Logger logger = Logger.getLogger("basicprogrammingmodel.exercises");

    private static final int SIDES = 6;
    

    public static void main(String[] args) {
        //diceExactProbabilityDistribution();
        int N = findSufficientN(.001);
        logger.info("N have to be " + N);
    }
    /**
     * 精确值的概率分布
     */
    public static double[] diceExactProbabilityDistribution(){
        double[] dist = new double[2*SIDES+1];
        for (int i = 1; i <= SIDES; i++) {
            for(int j=1; j <= SIDES; j++){
                dist[i+j] += 1.0;
            }
        }
        logger.info("dist:" + Arrays.toString(dist));
        double sum = 0.0;
        for (double var : dist) {
            sum += var;
        }
        logger.info("dist sum: " + sum);
        for(int k=2; k <= 2*SIDES; k++){
            dist[k] /= SIDES * SIDES;
        }
        logger.info("dist:" + Arrays.toString(dist));
        return dist;
    }
    /**
     * 掷筛子
     * @return
     */
    private static int diceThrow(){
        return StdRandom.uniform(SIDES) + 1;
    }
    /**
     * 掷N次筛子，两个筛子和的概率分布
     * @param N
     * @return
     */
    private static double[] trackNDiceThrowsProbabilityResult(int N){
        double[] dist = new double[SIDES*2+1];
        for (int i = 0; i < N; i++) {
            int dice1 = diceThrow();
            int dice2 = diceThrow();
            dist[dice1 + dice2] += 1.0;
        }
        for (int i = 2; i < dist.length; i++) {
            dist[i] /= N;
        }
        return dist;
    }
    /**
     * 最大的差距
     * @param exactResults
     * @param empiricalResults
     * @return
     */
    private static double maxDisparity(double[] exactResults, double[] empiricalResults){
        double max_disp = Double.NEGATIVE_INFINITY;
        int indexMax = Math.max(exactResults.length, empiricalResults.length);
        for (int i = 2; i < indexMax; i++) {
            double disp = Math.abs(exactResults[i] - empiricalResults[i]);
            if (max_disp < disp) max_disp = disp;
        }
        return max_disp;
    }
    /**
     * 查找足量的N
     * @param disparity
     * @return
     */
    private static int findSufficientN(double disparity){
        double[] theoretical_dist = diceExactProbabilityDistribution();
        int N=35;
        double[] experiment_dist;
        do{
            N += 1;
            experiment_dist = trackNDiceThrowsProbabilityResult(N);
        }while(maxDisparity(theoretical_dist,experiment_dist) > disparity);
        return N;
    }

}