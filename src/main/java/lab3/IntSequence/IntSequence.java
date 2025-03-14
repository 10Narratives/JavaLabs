package lab3.IntSequence;

/**
 * Represents a sequence of integers with methods to retrieve the next integer
 * and check if more integers are available.
 */
public interface IntSequence {

    /**
     * Creates an IntSequence from the given array of integers.
     *
     * @param values the integers to include in the sequence
     * @return an IntSequence that iterates over the provided integers
     */
    static IntSequence of(int... values) {
        return new IntSequence() {
            private int current = 0;

            @Override
            public int next() {
                return values[current++];
            }

            @Override
            public boolean hasNext() {
                return current < values.length;
            }
        };
    }

    /**
     * Creates an infinite IntSequence that always returns the same constant value.
     *
     * @param value the constant value to be returned by the sequence
     * @return an infinite IntSequence that always returns the specified constant value
     */
    static IntSequence constant(int value) {
        return new IntSequence() {
            @Override
            public int next() {
                return value;
            }

            @Override
            public boolean hasNext() {
                return true;
            }
        };
    }

    /**
     * Returns the next integer in the sequence.
     *
     * @return the next integer in the sequence
     */
    int next();

    /**
     * Checks if there are more integers available in the sequence.
     *
     * @return true if there are more integers, false otherwise
     */
    boolean hasNext();
}