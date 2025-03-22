package lab2.queue;

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
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            builder.append(iterator.next()).append(" ");
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
        private Node curr, last, lastLast;
        private boolean canRemove = false;

        public Iterator() {
            this.curr = head;
            this.last = null;
            this.lastLast = null;
        }

        public boolean hasNext() {
            return this.curr != null;
        }

        public String next() {
            String value = curr.value;
            lastLast = last;
            last = curr;
            curr = curr.next;
            canRemove = true;
            return value;
        }

        public void remove() {
            if (lastLast == null) {
                curr = curr.next;
            } else {
                lastLast.next = curr;
            }
            last = lastLast;
            canRemove = false;
        }
    }
}
