package lab3.IntSequence;

import java.util.Random;

public final class RandomizedSequence {
    private static final Random generator = new Random();

    private static class RandomSequence implements IntSequence {
        private final int lowerBound;
        private final int upperBound;

        public RandomSequence(int lowerBound, int upperBound) {
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        }

        @Override
        public int next() {
            return lowerBound + generator.nextInt(upperBound - lowerBound + 1);
        }

        @Override
        public boolean hasNext() {
            return true;
        }
    }

    public static IntSequence randomInts(int lowerBound, int upperBound) {
        return new RandomSequence(lowerBound, upperBound);
    }
}
