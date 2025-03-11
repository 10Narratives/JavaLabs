package lab1;

import java.util.ArrayList;
import java.util.Collections;
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

        int maxNum = Collections.max(result.getLast());
        int maxNumLen = String.valueOf(maxNum).length();

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ".repeat(maxNumLen));
            }
            for (int num : result.get(i)) {
                String formatted = String.format("%" + maxNumLen + "d", num);
                System.out.printf(formatted + " ".repeat(maxNumLen));
            }
            System.out.println();
        }

    }
}
