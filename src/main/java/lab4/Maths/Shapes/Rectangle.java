package lab4.Maths.Shapes;

import lab4.Maths.Points.Point;


///The {@code Rectangle} class represents a rectangle in two-dimensional space.
public final class Rectangle extends Shape {
    private double width;
    private double height;

    /**
     * Constructs a new {@code Rectangle} instance with the specified top-left corner,
     * width, and height.
     *
     * @param topLeft the top-left corner of the rectangle
     * @param width   the width of the rectangle
     * @param height  the height of the rectangle
     */
    public Rectangle(Point topLeft, double width, double height) {
        super(topLeft);
        this.setWidth(width);
        this.setHeight(height);
    }

    /**
     * Returns the center point of the rectangle.
     *
     * @return the center point of the rectangle
     */
    @Override
    public Point getCenter() {
        return new Point(this.point.getX() + width / 2, this.point.getY() + height / 2);
    }

    /**
     * Returns the width of the rectangle.
     *
     * @return the width of the rectangle
     */
    public double getWidth() {
        return width;
    }

    /**
     * Sets the width of the rectangle.
     *
     * <p>If the provided width is negative, its absolute value is used to ensure
     * that the width remains non-negative.</p>
     *
     * @param width the new width of the rectangle
     */
    public void setWidth(double width) {
        if (width < 0) width *= -1;
        this.width = width;
    }

    /**
     * Returns the height of the rectangle.
     *
     * @return the height of the rectangle
     */
    public double getHeight() {
        return height;
    }

    /**
     * Sets the height of the rectangle.
     *
     * <p>If the provided height is negative, its absolute value is used to ensure
     * that the height remains non-negative.</p>
     *
     * @param height the new height of the rectangle
     */
    public void setHeight(double height) {
        if (height < 0) height *= -1;
        this.height = height;
    }

    /**
     * Creates and returns a copy of this rectangle.
     *
     * <p>This method overrides the {@link Shape#clone()} behavior to ensure that
     * the cloned rectangle has the same top-left corner, width, and height as the original.</p>
     *
     * @return a clone of this rectangle
     * @throws CloneNotSupportedException if cloning is not supported by the superclass
     */
    @Override
    public Rectangle clone() throws CloneNotSupportedException {
        Rectangle rectangle = (Rectangle) super.clone();
        rectangle.width = this.width;
        rectangle.height = this.height;
        return rectangle;
    }
}
