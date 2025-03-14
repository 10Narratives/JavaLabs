package lab4.Maths.Points;

import java.util.Objects;

/**
 * The {@code Point} class represents a point in a two-dimensional space with x and y coordinates.
 * It implements the {@link Cloneable} interface, allowing instances of this class to be cloned.
 */
public class Point implements Cloneable {
    /**
     * The x-coordinate of the point.
     */
    protected double x;

    /**
     * The y-coordinate of the point.
     */
    protected double y;

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

    /**
     * Returns the x-coordinate of the point.
     *
     * @return the x-coordinate of the point
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the y-coordinate of the point.
     *
     * @return the y-coordinate of the point
     */
    public double getY() {
        return y;
    }

    /**
     * Translates the point by adding the specified values to its x and y coordinates.
     *
     * @param dx the value to add to the x-coordinate
     * @param dy the value to add to the y-coordinate
     */
    public void translate(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    /**
     * Compares this point with another object for equality.
     *
     * <p>Two points are considered equal if they have the same x and y coordinates,
     * as determined by {@link Double#compare(double, double)}.</p>
     *
     * @param o the object to compare with this point
     * @return {@code true} if the given object is a point with the same coordinates; otherwise, {@code false}
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(this.x, point.x) == 0 && Double.compare(this.y, point.y) == 0;
    }

    /**
     * Returns a hash code value for the point.
     *
     * <p>The hash code is based on the x and y coordinates of the point,
     * computed using {@link Objects#hash(Object...)}.</p>
     *
     * @return a hash code value for the point
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }

    /**
     * Returns a string representation of the point.
     *
     * <p>The string representation is in the format: {@code Point{x=<x>, y=<y>}},
     * where <x> and <y> are the coordinates of the point.</p>
     *
     * @return a string representation of the point
     */
    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    /**
     * Creates and returns a copy of this point.
     *
     * <p>This method overrides the default {@link Object#clone()} behavior to ensure
     * that the cloned point has the same x and y coordinates as the original.</p>
     *
     * @return a clone of this point
     * @throws CloneNotSupportedException if cloning is not supported by the superclass
     */
    @Override
    public Point clone() throws CloneNotSupportedException {
        Point point = (Point) super.clone();
        point.x = this.x;
        point.y = this.y;
        return point;
    }
}