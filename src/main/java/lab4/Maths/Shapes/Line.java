package lab4.Maths.Shapes;

import lab4.Maths.Points.Point;


/// The {@code Line} class represents a line segment in two-dimensional space.
public final class Line extends Shape {
    private Point ending;

    /**
     * Constructs a new {@code Line} instance with the specified start and end points.
     *
     * @param from the starting point of the line
     * @param ending   the ending point of the line
     */
    public Line(Point from, Point ending) {
        super(from);
        setEnding(ending);
    }

    /// Retrieves the center point of the line.
    @Override
    public Point getCenter() {
        double centerX = (this.ending.getX() - this.point.getX()) / 2 + this.point.getX();
        double centerY = (this.ending.getY() - this.point.getY()) / 2 + this.point.getY();
        return new Point(centerX, centerY);
    }

    /// Retrieves the ending point of the line.
    public Point getEnding() {
        return ending;
    }

    /**
     * Sets the ending point of the line.
     *
     * @param ending the new ending point of the line
     */
    public void setEnding(Point ending) {
        this.ending = ending;
    }

    /**
     * Creates and returns a copy of this line.
     *
     * @return a clone of this line
     * @throws CloneNotSupportedException if cloning is not supported by the superclass
     */
    @Override
    public Line clone() throws CloneNotSupportedException {
        Line line = (Line) super.clone();
        line.ending = this.ending.clone();
        return line;
    }
}
