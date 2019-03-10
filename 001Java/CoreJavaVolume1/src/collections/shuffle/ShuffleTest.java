package collections.shuffle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This program demonstrates the random shuffle and sort algorithms.
 * @version 1.0 2019-01-26
 * @author Li Fei
 */
public class ShuffleTest {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 49; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        List<Integer> winningCombination = numbers.subList(0, 6);
        Collections.sort(winningCombination);
        System.out.println(winningCombination);
    }
}