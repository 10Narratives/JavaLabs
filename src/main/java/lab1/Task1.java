package lab1;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int value = in.nextInt();
        System.out.println(Integer.toBinaryString(value));
        System.out.println(Integer.toOctalString(value));
        System.out.println(Integer.toHexString(value));
    }
}
