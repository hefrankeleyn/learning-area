package collections.set;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * This program sorts a set of item by comparing their description
 * @version 1.0 2019-01-25
 * @author Li Fei
 */
public class TreeSetTest {

    public static void main(String[] args) {
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster",1234));
        parts.add(new Item("Widget",34));
        parts.add(new Item("Morden",156));
        // 
        System.out.println(parts);

        NavigableSet<Item> sortByDescription = new TreeSet<>(Comparator.comparing(Item::getDescription));
        
        sortByDescription.addAll(parts);

        System.out.println(sortByDescription);

    }
}