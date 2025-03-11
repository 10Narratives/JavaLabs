package lab2.Point;

/**
 * Represents a modifiable mathematical point in Cartesian space.
 */
public final class PointModifiable {
    private double x;
    private double y;

    /**
     * Constructs a new {@code PointModifiable} instance at the origin (0.0, 0.0).
     */
    public PointModifiable() {
        this.x = 0.0;
        this.y = 0.0;
    }

    /**
     * Constructs a new {@code PointModifiable} instance with the specified coordinates.
     *
     * @param x the initial x-coordinate of the point
     * @param y the initial y-coordinate of the point
     */
    public PointModifiable(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Retrieves the current x-coordinate of this {@code PointModifiable} instance.
     *
     * @return the current x-coordinate of the point
     */
    public double getX() {
        return this.x;
    }

    /**
     * Retrieves the current y-coordinate of this {@code PointModifiable} instance.
     *
     * @return the current y-coordinate of the point
     */
    public double getY() {
        return this.y;
    }

    /**
     * Translates this point by adding the specified deltas to its coordinates.
     * The new coordinates are calculated as {@code {x + deltaX; y + deltaY}}.
     *
     * @param deltaX the value to be added to the {@code x} coordinate
     * @param deltaY the value to be added to the {@code y} coordinate
     */
    public void translate(double deltaX, double deltaY) {
        this.x += deltaX;
        this.y += deltaY;
    }

    /**
     * Scales this point by multiplying both coordinates by the specified factor.
     * The new coordinates are calculated as {@code {value * x; value * y}}.
     *
     * @param value the scaling factor to be applied to both {@code x} and {@code y} coordinates
     */
    public void scale(double value) {
        this.x *= value;
        this.y *= value;
    }
}
