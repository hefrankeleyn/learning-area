package genericclass.pair2;

import java.time.LocalDate;
import java.util.logging.Logger;

import genericclass.Pair;

/**
 * PairTest2
 */
public class PairTest2 {
    private static final Logger logger = Logger.getLogger("genericclass.pair2");
    public static void main(String[] args) {
        LocalDate[] birthdays = {
            LocalDate.of(2001, 11, 23),
            LocalDate.of(2002, 9, 13),
            LocalDate.of(2012, 1, 6),
            LocalDate.of(2013, 10, 21),
            LocalDate.of(2011, 3, 3)
        };
        Pair<LocalDate> mm = ArrayAlg.minamx(birthdays);
        logger.info("min = " + mm.getFirst());
        logger.info("max = " + mm.getSecond());
    }
}

class ArrayAlg{
    
    public static <T extends Comparable> Pair<T> minamx(T[] a){
        if (a == null || a.length == 0) return null;
        T min = a[0];
        T max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pair<T>(min, max);
    }
}