package lab3.int_sequence;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RandomizedSequenceTest {

    @Test
    @DisplayName("Swaps bounds when lower > upper")
    void testBoundsSwapping() {
        IntSequence sequence = RandomizedSequence.randomInts(10, 5);
        for (int i = 0; i < 1000; i++) {
            int value = sequence.next();
            assertTrue(value >= 5 && value <= 10, "Value out of bounds: " + value);
        }
    }

    @Test
    @DisplayName("Generates numbers within normal bounds")
    void testNormalBounds() {
        IntSequence sequence = RandomizedSequence.randomInts(3, 7);
        for (int i = 0; i < 1000; i++) {
            int value = sequence.next();
            assertTrue(value >= 3 && value <= 7, "Value out of bounds: " + value);
        }
    }

    @Test
    @DisplayName("Generates only the singleton value when bounds are equal")
    void testSingletonRange() {
        IntSequence sequence = RandomizedSequence.randomInts(5, 5);
        for (int i = 0; i < 100; i++) {
            assertEquals(5, sequence.next(), "Should always return singleton value");
        }
    }

    @Test
    @DisplayName("hasNext() always returns true")
    void testInfiniteSequence() {
        IntSequence sequence = RandomizedSequence.randomInts(0, 1);
        for (int i = 0; i < 100; i++) {
            assertTrue(sequence.hasNext(), "hasNext() should always return true");
            sequence.next();
            assertTrue(sequence.hasNext(), "hasNext() should remain true after next()");
        }
    }

    @ParameterizedTest
    @CsvSource({
            "-10, 5",   // Lower < Upper (negative to positive)
            "5, -5",    // Upper < Lower (should swap)
            "-10, -5",  // Both negative
            "0, 10",    // Both positive
            "7, 3"      // Upper < Lower (should swap)
    })
    @DisplayName("Generates numbers within specified range (with bound swapping)")
    void testRangeBounds(int lower, int upper) {
        IntSequence sequence = RandomizedSequence.randomInts(lower, upper);
        int expectedMin = Math.min(lower, upper);
        int expectedMax = Math.max(lower, upper);

        for (int i = 0; i < 1000; i++) {
            int value = sequence.next();
            assertTrue(value >= expectedMin && value <= expectedMax,
                    String.format("Value %d out of range [%d, %d] (original bounds: %d, %d)",
                            value, expectedMin, expectedMax, lower, upper));
        }
    }

    @Test
    @DisplayName("Handles mixed sign ranges")
    void testMixedSignRange() {
        IntSequence sequence = RandomizedSequence.randomInts(-5, 5);
        for (int i = 0; i < 1000; i++) {
            int value = sequence.next();
            assertTrue(value >= -5 && value <= 5, "Value out of bounds: " + value);
        }
    }

    @Test
    @DisplayName("Generates zero when both bounds are zero")
    void testZeroRange() {
        IntSequence sequence = RandomizedSequence.randomInts(0, 0);
        for (int i = 0; i < 100; i++) {
            assertEquals(0, sequence.next(), "Should always return zero");
        }
    }
}