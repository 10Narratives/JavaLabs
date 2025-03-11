package lab2.Point;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PointModifiableTest {

    @Test
    void testDefaultConstructor() {
        PointModifiable point = new PointModifiable();
        assertEquals(0.0, point.getX(), 0.0001, "X coordinate should be 0.0");
        assertEquals(0.0, point.getY(), 0.0001, "Y coordinate should be 0.0");
    }

    @Test
    void testParameterizedConstructor() {
        PointModifiable point = new PointModifiable(3.0, 4.0);
        assertEquals(3.0, point.getX(), 0.0001, "X coordinate should match");
        assertEquals(4.0, point.getY(), 0.0001, "Y coordinate should match");
    }

    @Test
    void testTranslate() {
        PointModifiable point = new PointModifiable(3.0, 4.0);
        point.translate(2.0, -1.0);

        assertEquals(5.0, point.getX(), 0.0001, "Translated X coordinate should match");
        assertEquals(3.0, point.getY(), 0.0001, "Translated Y coordinate should match");
    }

    @Test
    void testScale() {
        PointModifiable point = new PointModifiable(3.0, 4.0);
        point.scale(2.0);

        assertEquals(6.0, point.getX(), 0.0001, "Scaled X coordinate should match");
        assertEquals(8.0, point.getY(), 0.0001, "Scaled Y coordinate should match");
    }

    @Test
    void testScaleWithZero() {
        PointModifiable point = new PointModifiable(3.0, 4.0);
        point.scale(0.0);

        assertEquals(0.0, point.getX(), 0.0001, "Scaled X coordinate should be 0.0");
        assertEquals(0.0, point.getY(), 0.0001, "Scaled Y coordinate should be 0.0");
    }

    @Test
    void testScaleWithNegativeFactor() {
        PointModifiable point = new PointModifiable(3.0, 4.0);
        point.scale(-2.0);

        assertEquals(-6.0, point.getX(), 0.0001, "Scaled X coordinate should match");
        assertEquals(-8.0, point.getY(), 0.0001, "Scaled Y coordinate should match");
    }

    @Test
    void testMultipleOperations() {
        PointModifiable point = new PointModifiable(1.0, 1.0);

        point.translate(2.0, 3.0);
        assertEquals(3.0, point.getX(), 0.0001, "X coordinate after translation should match");
        assertEquals(4.0, point.getY(), 0.0001, "Y coordinate after translation should match");

        point.scale(2.0);
        assertEquals(6.0, point.getX(), 0.0001, "X coordinate after scaling should match");
        assertEquals(8.0, point.getY(), 0.0001, "Y coordinate after scaling should match");

        point.translate(-1.0, -2.0);
        assertEquals(5.0, point.getX(), 0.0001, "X coordinate after second translation should match");
        assertEquals(6.0, point.getY(), 0.0001, "Y coordinate after second translation should match");
    }
}