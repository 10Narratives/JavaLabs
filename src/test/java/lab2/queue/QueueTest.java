package lab2.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    private Queue queue;

    @BeforeEach
    void setUp() {
        queue = new Queue();
    }

    @Test
    void testPushAndPop() {
        queue.push("A");
        queue.push("B");
        queue.push("C");

        assertEquals(3, queue.size(), "Queue size should be 3 after pushing 3 elements");

        assertEquals("A", queue.pop(), "First pop should return 'A'");
        assertEquals("B", queue.pop(), "Second pop should return 'B'");
        assertEquals("C", queue.pop(), "Third pop should return 'C'");

        assertEquals(0, queue.size(), "Queue size should be 0 after popping all elements");
    }

    @Test
    void testPopFromEmptyQueue() {
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> queue.pop());
        assertEquals("cannot pop from empty queue", exception.getMessage());
    }

    @Test
    void testPushAndSize() {
        assertEquals(0, queue.size(), "Initial queue size should be 0");

        queue.push("X");
        assertEquals(1, queue.size(), "Queue size should be 1 after pushing one element");

        queue.push("Y");
        assertEquals(2, queue.size(), "Queue size should be 2 after pushing two elements");
    }

    @Test
    void testIterator() {
        queue.push("A");
        queue.push("B");
        queue.push("C");

        Queue.Iterator iterator = queue.iterator();
        assertTrue(iterator.hasNext(), "Iterator should have next element");
        assertEquals("A", iterator.next(), "First element should be 'A'");
        assertEquals("B", iterator.next(), "Second element should be 'B'");
        assertEquals("C", iterator.next(), "Third element should be 'C'");
        assertFalse(iterator.hasNext(), "Iterator should not have next element after traversing all elements");
    }

    @Test
    void testIteratorNoSuchElementException() {
        Queue.Iterator iterator = queue.iterator();
        Exception exception = assertThrows(NoSuchElementException.class, iterator::next);
        assertEquals("cannot get next element from queue by null pointer", exception.getMessage());
    }

    @Test
    void testSingleElementQueue() {
        queue.push("OnlyElement");

        assertEquals(1, queue.size(), "Queue size should be 1 after pushing one element");
        assertEquals("OnlyElement", queue.pop(), "Popping should return the only element");
        assertEquals(0, queue.size(), "Queue size should be 0 after popping the only element");

        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> queue.pop());
        assertEquals("cannot pop from empty queue", exception.getMessage());
    }
}