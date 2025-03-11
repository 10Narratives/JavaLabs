package lab1;

import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String source = in.nextLine();
        String[] substrings = source.split(" ");
        for (String substring : substrings) {
            System.out.println(substring);
        }
    }
}
