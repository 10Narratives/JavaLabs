package lab4.Maths.Shapes;

import lab4.Maths.Points.Point;

/**
 * The {@code Shape} class is an abstract base class representing a geometric shape
 * located at a specific point in a two-dimensional space.
 */
public abstract class Shape implements Cloneable {
    protected Point point;

    /**
     * Constructs a new {@code Shape} instance with the specified reference point.
     *
     * @param point the reference point of the shape
     */
    public Shape(Point point) {
        this.point = point;
    }

    /**
     * Moves the shape by translating its reference point by the specified amounts
     * in the x and y directions.
     *
     * @param dx the amount to move the shape along the x-axis
     * @param dy the amount to move the shape along the y-axis
     */
    public void moveBy(double dx, double dy) {
        this.point.translate(dx, dy);
    }

    /**
     * Returns the center point of the shape.
     *
     * @return the center point of the shape
     */
    public abstract Point getCenter();

    /**
     * Creates and returns a copy of this shape.
     *
     * <p>This method overrides the default {@link Object#clone()} behavior to ensure
     * that the cloned shape has a deep copy of its reference point.</p>
     *
     * @return a clone of this shape
     * @throws CloneNotSupportedException if cloning is not supported by the superclass
     */
    @Override
    public Shape clone() throws CloneNotSupportedException {
        Shape shape = (Shape) super.clone();
        shape.point = this.point.clone();
        return shape;
    }
}
