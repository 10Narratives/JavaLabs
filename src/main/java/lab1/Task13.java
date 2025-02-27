package lab1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Task13 {
    public static void main(String[] args) {
        ArrayList<Integer> values = new ArrayList<>();
        for (int i = 0; i < 49; i++) {
            values.add(i + 1);
        }

        ArrayList<Integer> combination = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int index = random.nextInt(49);
            combination.add(values.remove(index));
        }

        Collections.sort(combination);
        System.out.println(combination);
    }
}
