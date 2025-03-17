package lab2.random_number;

import java.util.ArrayList;
import java.util.Random;

/// A utility class for generating random elements from collections or arrays.
public class RandomNumber {
    /**
     * Retrieves a random element from the given {@code ArrayList<Integer>}.
     * If the list is empty, the method returns 0 as a default value.
     * If the input list is null, an {@code IllegalArgumentException} is thrown.
     *
     * @param arr the {@code ArrayList<Integer>} from which a random element is to be retrieved
     * @return a randomly selected element from the list, or 0 if the list is empty
     * @throws IllegalArgumentException if the input list is null
     */
    public static int randomElement(ArrayList<Integer> arr) {
        if (arr == null)
            throw new IllegalArgumentException("Input list cannot be null.");

        if (arr.isEmpty())
            return 0;

        Random random = new Random();
        return arr.get(random.nextInt(arr.size()));
    }

    /**
     * Retrieves a random element from the given {@code int[]}.
     * If the array is empty, the method returns 0 as a default value.
     * If the input array is null, an {@code IllegalArgumentException} is thrown.
     *
     * @param arr the {@code int[]} from which a random element is to be retrieved
     * @return a randomly selected element from the array, or 0 if the array is empty
     * @throws IllegalArgumentException if the input array is null
     */
    public static int randomElement(int[] arr) {
        if (arr == null)
            throw new IllegalArgumentException("Input list cannot be null.");

        if (arr.length == 0)
            return 0;

        Random random = new Random();
        return arr[random.nextInt(Integer.MAX_VALUE) % arr.length];
    }
}