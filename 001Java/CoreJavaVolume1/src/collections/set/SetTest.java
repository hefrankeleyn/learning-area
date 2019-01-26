package collections.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Logger;

/**
 * SetTest
 */
public class SetTest {

    private static final Logger logger = Logger.getLogger("collections.set");
    public static void main(String[] args) {
        // HashSet implements set
        Set<String> words = new HashSet<>();
        long totalTime = 0;
        try (Scanner in = new Scanner(System.in)){
            while (in.hasNext()){
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }
        }
        Iterator<String> iter = words.iterator();
        for (int i = 1; i <= 20 && iter.hasNext(); i++) {
            logger.info(iter.next());
        }
        logger.info("....");
        logger.info(words.size() + "distinct words." + totalTime + "milliseconds.");
    }
}