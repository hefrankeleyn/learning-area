package collections.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Logger;

/**
 * This program demonstrates operations on linked lists.
 * @version 1.0 2019-01-25
 * @author Li Fei
 */
public class LinkedListTest {

    private static final Logger logger = Logger.getLogger("collections.linkedlist");

    public static void main(String[] args) {
        //runMain();
        testApi();
    }

    private static void testApi(){
        List<String> a = new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");
        a.add("ChengLong");
        a.add("ZhouXingChe");
        a.add("GaoZengQiang");
        // java.lang.IndexOutOfBoundsException
        ListIterator<String> iterator = a.listIterator(3);
        if(iterator.hasNext()){
            logger.info(iterator.next());
        }

        ListIterator<String> iter02 = a.listIterator(a.size());
        while (iter02.hasPrevious()) {
            logger.info(iter02.previous());
        }



        


    }
    /**
     * this program demonstrates operations on linked lists.
     */
    private static void runMain(){
        List<String> a = new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        List<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        // merge the words from b into a
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext()){
            if (aIter.hasNext()) aIter.next();
            aIter.add(bIter.next());
        }
        logger.info(a.toString());

        // remove every second word from b
        bIter = b.iterator();
        while (bIter.hasNext()){
            bIter.next(); // skip one element
            if (bIter.hasNext()){
                bIter.next(); // skip one element
                bIter.remove(); // remove that element
            }
        }
        logger.info(b.toString());
        // bulk operation: remove all worlds in b from a

        a.removeAll(b);
        logger.info(a.toString());


    }    
}