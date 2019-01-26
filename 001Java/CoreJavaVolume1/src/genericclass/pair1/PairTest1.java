package genericclass.pair1;

import java.util.logging.Logger;

import genericclass.Pair;

/**
 * PairTest1
 */
public class PairTest1 {

    private static final Logger logger = Logger.getLogger("genericclass.pair1");

    public static void main(String[] args) {
        String[] words = {"Mary", "had", "a", "little", "lamb"};
        Pair<String> mm = ArrayAlg.minmax(words);
        logger.info("min = " + mm.getFirst());
        logger.info("max = " + mm.getSecond());
    }
}

class ArrayAlg{
    /**
     * Gets the minimum and maximum of an array of strings.
     * @param a an array of strings
     * @return a pair with the min and max value, or null if a is null or empty.
     */
    public static Pair<String> minmax(String[] a){
        if (a == null || a.length == 0) return null;
        String min = a[0];
        String max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0 ) min = a[i];
            if (max.compareTo(a[i]) < 0 ) max = a[i];
        }
        return new Pair<>(min, max);
        
    }
}