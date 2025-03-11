package lab2.Queue;

import java.util.NoSuchElementException;

/**
 * A simple implementation of a queue data structure using a singly linked list.
 * This class supports operations such as pushing elements to the queue, popping elements from the queue,
 * retrieving the size of the queue, and iterating over its elements.
 */
public class Queue {

    private Node head;
    private Node tail;
    private int size;

    /**
     * Returns an iterator for traversing the elements of the queue.
     *
     * @return a new iterator instance
     */
    public Iterator iterator() {
        return new Iterator();
    }

    /**
     * Retrieves the number of elements currently in the queue.
     *
     * @return the size of the queue
     */
    public int getSize() {
        return size;
    }

    /**
     * Adds a new element to the end of the queue.
     *
     * @param x the element to be added to the queue
     */
    public void push(String x) {
        Node node = new Node(x);
        if (this.head == null) {
            head = tail = node;
        } else {
            this.tail.next = node;
            this.tail = this.tail.next;
        }
        this.size++;
    }

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the value of the element removed from the front of the queue
     * @throws IndexOutOfBoundsException if the queue is empty
     */
    public String pop() {
        if (this.size == 0) {
            throw new IndexOutOfBoundsException("cannot pop from empty queue");
        }
        String value = this.head.value;
        this.head = this.head.next;
        if (this.head == null) this.tail = null;
        this.size--;
        return value;
    }

    /**
     * A node in the singly linked list used to implement the queue.
     * Each node contains a value and a reference to the next node in the list.
     */
    static class Node {
        String value;
        Node next;

        /**
         * Constructs a new node with the specified value.
         *
         * @param value the value to be stored in the node
         */
        public Node(String value) {
            this.value = value;
            this.next = null;
        }
    }

    /**
     * An iterator for traversing the elements of the queue.
     * This iterator allows sequential access to the elements in the queue.
     */
    public class Iterator {
        private Node current;

        /**
         * Constructs a new iterator starting at the head of the queue.
         */
        public Iterator() {
            this.current = head;
        }

        /**
         * Checks if there are more elements to iterate over.
         *
         * @return {@code true} if there are more elements, {@code false} otherwise
         */
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Retrieves the next element in the queue and advances the iterator.
         *
         * @return the value of the next element in the queue
         * @throws NoSuchElementException if there are no more elements to iterate over
         */
        public String next() {
            if (current == null) {
                throw new NoSuchElementException("cannot get next element from queue by null pointer");
            }
            String data = current.value;
            current = current.next;
            return data;
        }
    }
}
