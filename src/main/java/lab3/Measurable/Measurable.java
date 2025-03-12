package lab3.Measurable;

/**
 * Represents an entity that can provide a measurement.
 * Implementing classes must define how the measurement is calculated
 * by implementing the {@link #getMeasure()} method.
 */
public interface Measurable {

    /**
     * Returns the measurement value of the entity.
     *
     * @return the measurement as a double value
     */
    double getMeasure();
}