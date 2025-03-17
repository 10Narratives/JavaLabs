package lab2.point;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointFabricTest {
    @Test
    void testFromCartesian() {
        Point point = PointFabric.fromCartesian(3.0, 4.0);

        assertEquals(3.0, point.getX(), 0.0001, "X coordinate should match");
        assertEquals(4.0, point.getY(), 0.0001, "Y coordinate should match");
    }

    @Test
    void testFromPolar() {
        double radius = 5.0;
        double angle = Math.PI / 4;

        Point point = PointFabric.fromPolar(radius, angle);

        double expectedX = radius * Math.cos(angle);
        double expectedY = radius * Math.sin(angle);

        assertEquals(expectedX, point.getX(), 0.0001, "X coordinate should match");
        assertEquals(expectedY, point.getY(), 0.0001, "Y coordinate should match");
    }

    @Test
    void testFromPolarWithZeroRadius() {
        double radius = 0.0;
        double angle = Math.PI / 2;

        Point point = PointFabric.fromPolar(radius, angle);

        assertEquals(0.0, point.getX(), 0.0001, "X coordinate should be 0");
        assertEquals(0.0, point.getY(), 0.0001, "Y coordinate should be 0");
    }

    @Test
    void testFromPolarWithNegativeRadius() {
        double radius = -5.0;
        double angle = Math.PI;

        Point point = PointFabric.fromPolar(radius, angle);

        double expectedX = radius * Math.cos(angle);
        double expectedY = radius * Math.sin(angle);

        assertEquals(expectedX, point.getX(), 0.0001, "X coordinate should match");
        assertEquals(expectedY, point.getY(), 0.0001, "Y coordinate should match");
    }

    @Test
    void testFromPolarWithFullCircleAngle() {
        double radius = 3.0;
        double angle = 2 * Math.PI;

        Point point = PointFabric.fromPolar(radius, angle);

        double expectedX = radius * Math.cos(angle);
        double expectedY = radius * Math.sin(angle);

        assertEquals(expectedX, point.getX(), 0.0001, "X coordinate should match");
        assertEquals(expectedY, point.getY(), 0.0001, "Y coordinate should match");
    }
}