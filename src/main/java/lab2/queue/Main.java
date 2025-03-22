package lab2.queue;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(5);
        list.add(6);
        list.add(10);
        Iterator<Integer> iter = list.iterator();
        iter.next();
        iter.next();
        iter.remove();
        iter.remove();
        System.out.println(list);
    }
}
