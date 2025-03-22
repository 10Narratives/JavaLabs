package lab2.queue;

import java.util.NoSuchElementException;

public class Queue {
    private Node head, tail;
    private int size;

    public void add(String x) {
        Node node = new Node(x);
        if (this.head == null) {
            this.head = this.tail = node;
        } else {
            this.tail.next = node;
            this.tail = this.tail.next;
        }
        this.size++;
    }

    public String remove() {
        if (this.head == null) {
            return null;
        }
        String removing = this.head.value;
        if (head == tail)
            head = tail = null;
        else
            this.head = this.head.next;
        this.size--;
        return removing;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Node current = this.head;
        while (current != null) {
            builder.append(current.value);
            current = current.next;
        }
        return builder.toString();
    }

    public Iterator iterator() {
        return new Iterator();
    }

    static class Node {
        String value;
        Node next;

        public Node(String value) {
            this.value = value;
        }
    }

    public class Iterator {
        private Node pointer, last;

        public Iterator() {
            this.pointer = head;
            this.last = null;
        }

        public boolean hasNext() {
            return this.pointer != null;
        }

        public String next() {
            String value = pointer.value;
            last = pointer;
            pointer = pointer.next;
            return value;
        }

        public void remove() {
            if (last == null)
                return;

            Node nextElement = this.last.next;

            if (this.last == Queue.this.head) {
                Queue.this.head = Queue.this.head.next;
                if (Queue.this.head == null) {
                    Queue.this.tail = null;
                }
            } else {
                Node prev = Queue.this.head;
                while (prev != null && prev.next != this.last) {
                    prev = prev.next;
                }
                if (prev != null) {
                    prev.next = this.last.next;
                    if (this.last == Queue.this.tail) {
                        Queue.this.tail = prev;
                    }
                }
            }
            Queue.this.size--;
            this.last = nextElement;
        }
    }
}
