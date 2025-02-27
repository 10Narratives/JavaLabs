package lab1;

import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String source = in.nextLine();

        for (int i = 0; i < source.length(); i++) {
            char current = source.charAt(i);
            if (current > 127) {
                System.out.println(current + " U+" + Integer.toHexString(current).toUpperCase());
            }
        }
    }
}
