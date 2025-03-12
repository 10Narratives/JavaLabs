package lab3.LuckySort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A utility class that provides a method to sort an ArrayList of strings
 * using a randomized shuffling approach until the list matches the sorted order.
 */
public class LuckySort {

    /**
     * Sorts the given list of strings by repeatedly shuffling it until it matches
     * the order defined by the provided comparator.
     *
     * @param strings the list of strings to be sorted
     * @param cmp     the comparator defining the desired order of the strings
     * @throws NullPointerException if the input list or comparator is null
     */
    public static void luckySort(ArrayList<String> strings, Comparator<String> cmp) {
        List<String> copy = new ArrayList<>(strings);
        copy.sort(cmp);
        while (!strings.equals(copy)) {
            Collections.shuffle(strings);
        }
    }
}