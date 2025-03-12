package lab3.IntSequence;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IntSequenceTest {

    @Test
    void testHasNextTrue() {
        IntSequence sequence = IntSequence.of(1, 2, 3);
        assertTrue(sequence.hasNext(), "The sequence should have more elements initially.");
    }

    @Test
    void testHasNextFalse() {
        IntSequence sequence = IntSequence.of();
        assertFalse(sequence.hasNext(), "An empty sequence should not have any elements.");
    }

    @Test
    void testNextSingleElement() {
        IntSequence sequence = IntSequence.of(42);
        int value = sequence.next();
        assertEquals(42, value, "The next value should be 42.");
        assertFalse(sequence.hasNext(), "The sequence should be empty after retrieving the only element.");
    }

    @Test
    void testNextMultipleElements() {
        IntSequence sequence = IntSequence.of(10, 20, 30);
        assertEquals(10, sequence.next(), "The first value should be 10.");
        assertEquals(20, sequence.next(), "The second value should be 20.");
        assertEquals(30, sequence.next(), "The third value should be 30.");
        assertFalse(sequence.hasNext(), "The sequence should be empty after retrieving all elements.");
    }

    @Test
    void testEmptySequence() {
        IntSequence sequence = IntSequence.of();
        assertFalse(sequence.hasNext(), "An empty sequence should not have any elements.");
    }

    @Test
    void testLargeSequence() {
        int[] largeArray = new int[1000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = i + 1;
        }
        IntSequence sequence = IntSequence.of(largeArray);

        for (int i = 0; i < largeArray.length; i++) {
            assertTrue(sequence.hasNext(), "The sequence should have more elements.");
            assertEquals(i + 1, sequence.next(), "The next value should match the expected value.");
        }
        assertFalse(sequence.hasNext(), "The sequence should be empty after retrieving all elements.");
    }
}