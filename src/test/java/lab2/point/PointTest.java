package lab2.point;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointTest {
    @Test
    void testDefaultConstructor() {
        Point point = new Point();
        assertEquals(0.0, point.getX(), 0.0001, "X coordinate should be 0.0");
        assertEquals(0.0, point.getY(), 0.0001, "Y coordinate should be 0.0");
    }

    @Test
    void testParameterizedConstructor() {
        Point point = new Point(3.0, 4.0);
        assertEquals(3.0, point.getX(), 0.0001, "X coordinate should match");
        assertEquals(4.0, point.getY(), 0.0001, "Y coordinate should match");
    }

    @Test
    void testTranslate() {
        Point original = new Point(3.0, 4.0);
        Point translated = original.translate(2.0, -1.0);

        assertEquals(5.0, translated.getX(), 0.0001, "Translated X coordinate should match");
        assertEquals(3.0, translated.getY(), 0.0001, "Translated Y coordinate should match");

        assertEquals(3.0, original.getX(), 0.0001, "Original X coordinate should remain unchanged");
        assertEquals(4.0, original.getY(), 0.0001, "Original Y coordinate should remain unchanged");
    }

    @Test
    void testScale() {
        Point original = new Point(3.0, 4.0);
        Point scaled = original.scale(2.0);

        assertEquals(6.0, scaled.getX(), 0.0001, "Scaled X coordinate should match");
        assertEquals(8.0, scaled.getY(), 0.0001, "Scaled Y coordinate should match");

        assertEquals(3.0, original.getX(), 0.0001, "Original X coordinate should remain unchanged");
        assertEquals(4.0, original.getY(), 0.0001, "Original Y coordinate should remain unchanged");
    }

    @Test
    void testScaleWithZero() {
        Point original = new Point(3.0, 4.0);
        Point scaled = original.scale(0.0);

        assertEquals(0.0, scaled.getX(), 0.0001, "Scaled X coordinate should be 0.0");
        assertEquals(0.0, scaled.getY(), 0.0001, "Scaled Y coordinate should be 0.0");

        assertEquals(3.0, original.getX(), 0.0001, "Original X coordinate should remain unchanged");
        assertEquals(4.0, original.getY(), 0.0001, "Original Y coordinate should remain unchanged");
    }

    @Test
    void testScaleWithNegativeFactor() {
        Point original = new Point(3.0, 4.0);
        Point scaled = original.scale(-2.0);

        assertEquals(-6.0, scaled.getX(), 0.0001, "Scaled X coordinate should match");
        assertEquals(-8.0, scaled.getY(), 0.0001, "Scaled Y coordinate should match");

        assertEquals(3.0, original.getX(), 0.0001, "Original X coordinate should remain unchanged");
        assertEquals(4.0, original.getY(), 0.0001, "Original Y coordinate should remain unchanged");
    }
}