package lab1;

import java.util.ArrayList;
import java.util.Arrays;

public class AdditionalTask {
    public static void main(String[] args) {
        MyArrayList array = new MyArrayList(2);
        System.out.println(array);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(5);
        list.set(3, 100);
        System.out.println(list);

        array.add(10);
        array.add(15);
        System.out.println(array);

        array.add(15);
        System.out.println(array);

        System.out.println(array.get(0));
        try {
            array.get(100);
        } catch (IndexOutOfBoundsException exception) {
            System.out.println(exception);
        }
        try {
            array.get(-100);
        } catch (IndexOutOfBoundsException exception) {
            System.out.println(exception);
        }

        array.set(0, -100);
        System.out.println(array);
        try {
            array.set(100, -100);
        } catch (IndexOutOfBoundsException exception) {
            System.out.println(exception);
        }
        try {
            array.set(-100, -100);
        } catch (IndexOutOfBoundsException exception) {
            System.out.println(exception);
        }
    }

    public static class MyArrayList {
        int capacity;
        int size;
        int[] data;

        public MyArrayList(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.data = new int[capacity];
        }

        public void add(int x) {
            if (this.size == this.capacity) {
                // allocate new array and copy all values to it
                this.data = Arrays.copyOf(this.data, 2 * this.capacity);
            }
            this.data[this.size] = x;
            size++;
        }

        public int get(int index) {
            if (index >= size || index < 0) {
                throw new IndexOutOfBoundsException("index is out of bounds!!!");
            }
            return this.data[index];
        }

        public void set(int index, int x) {
            if (index >= size || index < 0) {
                throw new IndexOutOfBoundsException("index is oud of bounds!!!");
            }
            this.data[index] = x;
        }

        @Override
        public String toString() {
            return "MyArrayList{" +
                    "capacity=" + capacity +
                    ", size=" + size +
                    ", data=" + Arrays.toString(data) +
                    '}';
        }
    }
}
