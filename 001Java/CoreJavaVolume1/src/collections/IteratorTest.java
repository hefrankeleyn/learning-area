package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 * IteratorTest
 */
public class IteratorTest {

    private static final Logger logger = Logger.getLogger("genericclass.collections");

    public static void main(String[] args) {
       // removeElement();
       linkTest();
    }

    public static void collectionTest(){
        
    }
    private static void linkTest(){
        List<String> list = new LinkedList<>();
        list.add("xiaoMing");
        list.add("xiaoHong");
        list.add("zhoujieLun");
        list.add("chenglong");
        list.add("liuDeHua");
        logger.info(list.toString());

        Iterator<String> iterator=list.iterator();
        iterator.next();
        iterator.next();
        iterator.remove();
        logger.info(list.toString());
        
    }

    public static void removeElement(){
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        logger.info(list.toString());
        Iterator<String> it = list.iterator();
        it.next();
        it.remove();
        it.next();
        it.remove();
        logger.info(list.toString());
    }
}