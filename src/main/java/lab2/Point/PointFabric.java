package lab2.Point;


/// A factory class for creating instances of {@code Point} using different coordinate systems.
public class PointFabric {

    /**
     * Creates a new {@code Point} instance from Cartesian coordinates.
     *
     * @param x the x-coordinate of the point in Cartesian space
     * @param y the y-coordinate of the point in Cartesian space
     * @return a new {@code Point} instance with the specified Cartesian coordinates
     */
    public static Point fromCartesian(double x, double y) {
        return new Point(x, y);
    }

    /**
     * Creates a new {@code Point} instance from polar coordinates.
     * The polar coordinates are converted to Cartesian coordinates using the formulas:
     * <ul>
     *   <li>{@code x = radius * cos(angle)}</li>
     *   <li>{@code y = radius * sin(angle)}</li>
     * </ul>
     *
     * @param radius the radial distance from the origin (0, 0) in polar space
     * @param angle  the angle (in radians) from the positive x-axis in polar space
     * @return a new {@code Point} instance with the equivalent Cartesian coordinates
     */
    public static Point fromPolar(double radius, double angle) {
        double x = radius * Math.cos(angle);
        double y = radius * Math.sin(angle);
        return new Point(x, y);
    }
}

