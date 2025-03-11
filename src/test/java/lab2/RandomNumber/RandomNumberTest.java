package lab2.RandomNumber;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberTest {

    @Test
    void testRandomElement_NullArrayList_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            RandomNumber.randomElement((ArrayList<Integer>) null);
        });
    }

    @Test
    void testRandomElement_EmptyArrayList_ReturnsZero() {
        ArrayList<Integer> list = new ArrayList<>();
        assertEquals(0, RandomNumber.randomElement(list));
    }

    @Test
    void testRandomElement_NonEmptyArrayList_ReturnsElementFromList() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        int result = RandomNumber.randomElement(list);
        assertTrue(list.contains(result));
    }

    @Test
    void testRandomElement_SingleElementArrayList_ReturnsThatElement() {
        ArrayList<Integer> list = new ArrayList<>(Collections.singletonList(42));
        assertEquals(42, RandomNumber.randomElement(list));
    }

    @Test
    void testRandomElement_NullArray_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            RandomNumber.randomElement((int[]) null);
        });
    }

    @Test
    void testRandomElement_EmptyArray_ReturnsZero() {
        int[] arr = new int[0];
        assertEquals(0, RandomNumber.randomElement(arr));
    }

    @Test
    void testRandomElement_NonEmptyArray_ReturnsElementFromArray() {
        int[] arr = {10, 20, 30};
        int result = RandomNumber.randomElement(arr);
        assertTrue(Arrays.stream(arr).anyMatch(x -> x == result));
    }

    @Test
    void testRandomElement_SingleElementArray_ReturnsThatElement() {
        int[] arr = {100};
        assertEquals(100, RandomNumber.randomElement(arr));
    }
}