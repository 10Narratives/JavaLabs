package lab4.Maths.Points;

import java.util.Objects;

/**
 * The {@code PointLabeled} class extends the {@link Point} class and adds a label to represent
 * a labeled point in a two-dimensional space.
 */
public class PointLabeled extends Point {
    /**
     * The label associated with the point.
     */
    private String label;

    /**
     * Constructs a new {@code PointLabeled} instance with the specified coordinates and label.
     *
     * @param x     the x-coordinate of the point
     * @param y     the y-coordinate of the point
     * @param label the label associated with the point
     */
    public PointLabeled(double x, double y, String label) {
        super(x, y);
        this.label = label;
    }

    /**
     * Returns the label associated with the point.
     *
     * @return the label of the point
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the label associated with the point.
     *
     * @param label the new label for the point
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Compares this labeled point with another object for equality.
     *
     * <p>Two labeled points are considered equal if they have the same coordinates (as defined
     * by the superclass {@link Point#equals(Object)}) and the same label.</p>
     *
     * @param o the object to compare with this labeled point
     * @return {@code true} if the given object is a labeled point with the same coordinates
     *         and label; otherwise, {@code false}
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PointLabeled that = (PointLabeled) o;
        return Objects.equals(getLabel(), that.getLabel());
    }

    /**
     * Returns a hash code value for the labeled point.
     *
     * <p>The hash code is based on the hash code of the superclass and the label,
     * computed using {@link Objects#hash(Object...)}.</p>
     *
     * @return a hash code value for the labeled point
     */
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getLabel());
    }

    /**
     * Returns a string representation of the labeled point.
     *
     * <p>The string representation is in the format:
     * {@code PointLabeled{label='<label>', x=<x>, y=<y>}}, where <label> is the label of the point,
     * and <x> and <y> are the coordinates of the point.</p>
     *
     * @return a string representation of the labeled point
     */
    @Override
    public String toString() {
        return "PointLabeled{" +
                "label='" + label + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    /**
     * Creates and returns a copy of this labeled point.
     *
     * <p>This method overrides the {@link Point#clone()} behavior to ensure that the cloned
     * labeled point has the same coordinates and label as the original.</p>
     *
     * @return a clone of this labeled point
     * @throws CloneNotSupportedException if cloning is not supported by the superclass
     */
    @Override
    public PointLabeled clone() throws CloneNotSupportedException {
        PointLabeled labeled = (PointLabeled) super.clone();
        labeled.label = this.label;
        return labeled;
    }
}
