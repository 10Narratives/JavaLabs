package lab1;

import java.util.ArrayList;
import java.util.Scanner;

public class Task15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);

        if (n <= 1) {
            System.out.println(result);
        }

        for (int i = 1; i < n; i++) {
            result.add(new ArrayList<Integer>());
            result.getLast().add(1);
            for (int j = 0; j < i - 1; j++) {
                result.get(i).add(result.get(i - 1).get(j) + result.get(i - 1).get(j + 1));
            }
            result.getLast().add(1);
        }
        System.out.println(result);
    }
}
