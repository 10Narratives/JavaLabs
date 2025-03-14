package lab3.Employment;

/**
 * Defines the sorting options for the {@link Stuff} class.
 * These options determine the order in which employees are sorted.
 *
 * <p>
 * Each constant represents a specific sorting direction:
 * <ul>
 *   <li>{@link #ACS}: Sorts employees in ascending order of their measure (e.g., salary).</li>
 *   <li>{@link #DESC}: Sorts employees in descending order of their measure (e.g., salary).</li>
 * </ul>
 *
 * <p>
 * These options are used by the {@link Stuff#sort(StuffSortingOptions)} method to control the sorting behavior.
 */
public enum StuffSortingOptions {

    /**
     * Represents ascending order.
     * When used, employees are sorted by their measure (e.g., salary) in ascending order,
     * followed by their name in ascending order.
     */
    ACS,

    /**
     * Represents descending order.
     * When used, employees are sorted by their measure (e.g., salary) in descending order,
     * followed by their name in ascending order.
     */
    DESC
}