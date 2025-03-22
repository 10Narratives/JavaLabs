package lab3.lucky_sort;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LuckySortTest {

    @Test
    void testLuckySortWithNaturalOrder() {
        ArrayList<String> strings = new ArrayList<>(List.of("banana", "apple", "cherry"));
        Comparator<String> cmp = Comparator.naturalOrder();

        LuckySort.luckySort(strings, cmp);

        assertEquals(List.of("apple", "banana", "cherry"), strings, "The list should be sorted in natural order.");
    }

    @Test
    void testLuckySortWithReverseOrder() {
        ArrayList<String> strings = new ArrayList<>(List.of("apple", "banana", "cherry"));
        Comparator<String> cmp = Comparator.reverseOrder();

        LuckySort.luckySort(strings, cmp);

        assertEquals(List.of("cherry", "banana", "apple"), strings, "The list should be sorted in reverse order.");
    }

    @Test
    void testLuckySortWithCustomComparator() {
        ArrayList<String> strings = new ArrayList<>(List.of("aaa", "bb", "c"));
        Comparator<String> cmp = Comparator.comparingInt(String::length);

        LuckySort.luckySort(strings, cmp);

        assertEquals(List.of("c", "bb", "aaa"), strings, "The list should be sorted by string length.");
    }

    @Test
    void testLuckySortAlreadySorted() {
        ArrayList<String> strings = new ArrayList<>(List.of("apple", "banana", "cherry"));
        Comparator<String> cmp = Comparator.naturalOrder();

        // Already sorted
        LuckySort.luckySort(strings, cmp);

        assertEquals(List.of("apple", "banana", "cherry"), strings, "The list should remain unchanged.");
    }

    @Test
    void testLuckySortEmptyList() {
        ArrayList<String> strings = new ArrayList<>();
        Comparator<String> cmp = Comparator.naturalOrder();

        LuckySort.luckySort(strings, cmp);

        assertTrue(strings.isEmpty(), "The list should remain empty.");
    }

    @Test
    void testLuckySortSingleElement() {
        ArrayList<String> strings = new ArrayList<>(List.of("onlyOne"));
        Comparator<String> cmp = Comparator.naturalOrder();

        LuckySort.luckySort(strings, cmp);

        assertEquals(List.of("onlyOne"), strings, "The list with a single element should remain unchanged.");
    }

    @Test
    void testLuckySortNullListThrowsException() {
        ArrayList<String> strings = null;
        Comparator<String> cmp = Comparator.naturalOrder();

        assertThrows(NullPointerException.class, () -> LuckySort.luckySort(strings, cmp),
                "A null list should throw a NullPointerException.");
    }
}