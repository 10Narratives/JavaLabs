package lab2.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    @Test
    void testAdd() {
        Queue queue = new Queue();
        queue.add("A");
        assertEquals(1, queue.size());
        queue.add("B");
        assertEquals(2,queue.size());
        assertEquals("AB", queue.toString());
    }

    @Test
    void testRemove() {
        Queue queue = new Queue();
        queue.add("A");
        queue.add("A");
        queue.add("A");

        while (!queue.isEmpty()) {
            String removedValue = queue.remove();
            assertEquals("A", removedValue);
        }

        String emptyString = queue.remove();
        assertNull(emptyString);
    }

    @Test
    void testIterator() {
        Queue queue = new Queue();
        queue.add("A");
        queue.add("B");
        queue.add("C");

        Queue.Iterator iterator = queue.iterator();
        assertTrue(iterator.hasNext());
        assertEquals("A", iterator.next());
        assertEquals("B", iterator.next());
        assertEquals("C", iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testIteratorRemove_HeadElement() {
        Queue queue = new Queue();
        queue.add("A");
        queue.add("B");
        queue.add("C");

        Queue.Iterator iterator = queue.iterator();
        iterator.next();
        iterator.remove();
        assertEquals("BC", queue.toString());
    }

    @Test
    void testIteratorRemove_OneElement() {
        Queue queue = new Queue();
        queue.add("A");

        Queue.Iterator iterator = queue.iterator();
        iterator.next();
        iterator.remove();
        assertEquals("", queue.toString());
    }

    @Test
    void testIteratorRemove_NonHeadElement() {
        Queue queue = new Queue();
        queue.add("A");
        queue.add("B");
        queue.add("C");

        Queue.Iterator iterator = queue.iterator();
        iterator.next();
        iterator.next();
        iterator.remove();
        assertEquals("AC", queue.toString());
    }

    @Test
    void testIteratorRemove_LastElement() {
        Queue queue = new Queue();
        queue.add("A");
        queue.add("B");
        queue.add("C");

        Queue.Iterator iterator = queue.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.remove();
        assertEquals("AB", queue.toString());
    }
}