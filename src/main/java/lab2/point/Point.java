package lab2.point;

/// Represents a mathematical point.
public final class Point {
    private final double x;
    private final double y;

    ///Constructs a new {@code Point} instance at the origin (0.0, 0.0).
    public Point() {
        this.x = 0.0;
        this.y = 0.0;
    }

    /**
     * Constructs a new {@code Point} instance with the specified coordinates.
     *
     * @param x the x-coordinate of the point
     * @param y the y-coordinate of the point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }


    /// Retrieves the x-coordinate of this {@code Point} instance.
    public double getX() {
        return this.x;
    }


    ///Retrieves the y-coordinate of this {@code Point} instance.
    public double getY() {
        return this.y;
    }

    /**
     * Creates a new instance of {@code Point} with coordinates translated by the specified deltas.
     * The new coordinates are calculated as {@code {x + deltaX; y + deltaY}}.
     *
     * @param deltaX the value to be added to the {@code x} coordinate
     * @param deltaY the value to be added to the {@code y} coordinate
     * @return a new {@code Point} instance with the translated coordinates
     */
    public Point translate(double deltaX, double deltaY) {
        return new Point(this.x + deltaX, this.y + deltaY);
    }

    /**
     * Creates a new instance of {@code Point} with coordinates scaled by the specified factor.
     * The new coordinates are calculated as {@code {value * x; value * y}}.
     *
     * @param value the scaling factor to be applied to both {@code x} and {@code y} coordinates
     * @return a new {@code Point} instance with the scaled coordinates
     */
    public Point scale(double value) {
        return new Point(this.x * value, this.y * value);
    }
}