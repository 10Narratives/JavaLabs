package lab3.int_sequence;

import java.util.Random;

/**
 * A utility class for generating infinite sequences of random integers within a specified range.
 * This class provides a static method to create an {@link IntSequence} that generates random integers.
 *
 * <p>
 * The generated sequence is infinite, meaning the {@link RandomSequence#hasNext()} method always returns {@code true}.
 * Each call to {@link RandomSequence#next()} produces a new random integer within the specified bounds.
 */
public final class RandomizedSequence {

    /**
     * A shared random number generator used to produce random integers.
     */
    private static final Random generator = new Random();

    /**
     * Creates an infinite {@link IntSequence} that generates random integers within the specified range.
     *
     * <p>
     * If the provided {@code lowerBound} is greater than {@code upperBound}, the bounds are swapped internally
     * to ensure the range is valid.
     *
     * @param lowerBound the intended inclusive lower bound of the random integers
     * @param upperBound the intended inclusive upper bound of the random integers
     * @return an infinite {@link IntSequence} that generates random integers in the range [lowerBound, upperBound]
     */
    public static IntSequence randomInts(int lowerBound, int upperBound) {
        return new RandomSequence(lowerBound, upperBound);
    }

    /**
     * A private static class that implements the {@link IntSequence} interface to generate random integers.
     * This class represents an infinite sequence of random integers within a specified range.
     */
    private static class RandomSequence implements IntSequence {

        /**
         * The inclusive lower bound of the random integers.
         */
        private final int lowerBound;

        /**
         * The inclusive upper bound of the random integers.
         */
        private final int upperBound;

        /**
         * Constructs a {@code RandomSequence} with the specified bounds.
         * If the {@code lowerBound} is greater than {@code upperBound}, the bounds are swapped internally
         * to ensure the range is valid.
         *
         * @param lowerBound the intended inclusive lower bound of the random integers
         * @param upperBound the intended inclusive upper bound of the random integers
         */
        public RandomSequence(int lowerBound, int upperBound) {
            if (lowerBound > upperBound) {
                int tmp = lowerBound;
                lowerBound = upperBound;
                upperBound = tmp;
            }
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        }

        /**
         * Returns the next random integer in the sequence.
         * The value is randomly generated within the range [lowerBound, upperBound].
         *
         * @return the next random integer in the sequence
         */
        @Override
        public int next() {
            return lowerBound + generator.nextInt(upperBound - lowerBound + 1);
        }

        /**
         * Checks if there are more integers available in the sequence.
         * Since this sequence is infinite, this method always returns {@code true}.
         *
         * @return {@code true}, indicating the sequence is infinite
         */
        @Override
        public boolean hasNext() {
            return true;
        }
    }
}
