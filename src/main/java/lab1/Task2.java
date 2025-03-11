package lab1;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int value = in.nextInt();

        System.out.println(value % 360 + 360);
        System.out.println(Math.floorMod(value, 360));
    }
}
