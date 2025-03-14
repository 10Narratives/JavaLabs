package lab4.Maths.Shapes;

import lab4.Maths.Points.Point;


/// The {@code Circle} class represents a circle in two-dimensional space.
public final class Circle extends Shape {
    private double radius;

    /**
     * Constructs a new {@code Circle} instance with the specified center point and radius.
     *
     * @param point  the center point of the circle
     * @param radius the radius of the circle
     */
    public Circle(Point point, double radius) {
        super(point);
        this.setRadius(radius);
    }

    /**
     * Returns the center point of the circle.
     *
     * <p>This method implements the abstract {@link Shape#getCenter()} method
     * by returning the reference point of the circle.</p>
     *
     * @return the center point of the circle
     */
    @Override
    public Point getCenter() {
        return super.point;
    }

    /**
     * Returns the radius of the circle.
     *
     * @return the radius of the circle
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Sets the radius of the circle.
     *
     * <p>If the provided radius is negative, its absolute value is used to ensure
     * that the radius remains non-negative.</p>
     *
     * @param radius the new radius of the circle
     */
    public void setRadius(double radius) {
        if (radius < 0) radius *= -1;
        this.radius = radius;
    }

    /**
     * Creates and returns a copy of this circle.
     *
     * <p>This method overrides the {@link Shape#clone()} behavior to ensure that
     * the cloned circle has the same center point and radius as the original.</p>
     *
     * @return a clone of this circle
     * @throws CloneNotSupportedException if cloning is not supported by the superclass
     */
    @Override
    public Circle clone() throws CloneNotSupportedException {
        Circle circle = (Circle) super.clone();
        circle.radius = this.radius;
        return circle;
    }
}
