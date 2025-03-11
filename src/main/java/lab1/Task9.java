package lab1;

import java.util.Scanner;

public class Task9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1, s2;
        s1 = in.nextLine();
        s2 = in.nextLine();

        if (s1.compareTo(s2) == 0) {
            System.out.println("strings are equal");
        } else {
            System.out.println("strings are not equal");
        }
    }
}
