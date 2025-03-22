package lab3.comparator;

public class PointComparator implements Comparator<Point> {
    @Override
    public int compare(Point obj1, Point obj2) {
        int xComp = Double.compare(obj1.getX(), obj2.getX());
        if (xComp != 0) {
            return xComp;
        }
        return Double.compare(obj1.getY(), obj2.getY());
    }
}
