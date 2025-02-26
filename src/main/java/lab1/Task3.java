package lab1;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] values = new int[3];

        for (int i = 0; i < 3; i++) {
            values[i] = in.nextInt();
        }

        int max = Integer.MIN_VALUE;
        for (int value : values) {
            if (value > max) {
                max = value;
            }
        }
        System.out.println(max);

        max = Integer.MIN_VALUE;
        for (int value : values) {
            max = Math.max(max, value);
        }
        System.out.println(max);

    }
}

