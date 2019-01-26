package genericclass.pair3;

import java.util.logging.Logger;

//import genericclass.Pair;
import inheritance.Employee;
import inheritance.Manager;

/**
 * PairTest3
 */
public class PairTest3 {

    private static final Logger logger= Logger.getLogger("genericclass.pair3");

    public static void main(String[] args) {
        Manager ceo = new Manager("aaa", 30000, 2019, 01, 03);
        Manager cfo = new Manager("bbb", 31000, 2018, 11, 13);
        Pair<Manager> buddies = new Pair<>(ceo, cfo);
        printBuddies(buddies);

        ceo.setBonus(1000);
        cfo.setBonus(200);

        Manager[] managers = {ceo, cfo};
        Pair<Employee> result = new Pair<>();
        minmaxBonus(managers, result);
        logger.info("first: " + result.getFirst().getName() + ", second: " + result.getSecond().getName());
        maxminBonus(managers, result);
        logger.info("first: " + result.getFirst().getName() + ", second: " + result.getSecond().getName());

    }
    /**
     * print buddies
     * @param p
     */
    public static void printBuddies(Pair<? super Manager> p){
        Employee first = (Employee)p.getFirst();
        Employee second = (Employee)p.getSecond();
        logger.info(first.getName() + " and " + second.getName() + " are buddies.");

    }

    public static void minmaxBonus(Manager[] a, Pair<? super Manager> result){
        if (a.length == 0) return;
        Manager min = a[0];
        Manager max = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min.getBonus() > a[i].getBonus()) min = a[i];
            if (max.getBonus() < a[i].getBonus()) max = a[i];
        }
        result.setFirst(min);
        result.setSecond(max);
    }

    public static void maxminBonus(Manager[] a, Pair<? super Manager> result){
        minmaxBonus(a, result);
        //PairAlg.swap(result);  
        PairAlg.swapHelper(result);
    }
}

class PairAlg{
    public static boolean hasNulls(Pair<?> p){
        return p.getFirst() == null || p.getSecond() == null;
    }

    public static void swap(Pair<?> p) { swapHelper(p);}

    public static <T> void swapHelper(Pair<T> p){
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }
}