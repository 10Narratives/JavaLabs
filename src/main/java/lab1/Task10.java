package lab1;

import java.util.Random;
import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int targetLen = scanner.nextInt();

        Random random = new Random();
        StringBuilder builder = new StringBuilder(targetLen);
        while (builder.length() < targetLen) {
            long randomLong = random.nextLong();
            if (randomLong < 0) randomLong *= -1;
            String str = Long.toString(randomLong, 36);
            for (int i = 0; i < str.length(); i++) {
                builder.append(str.charAt(i));
                if (builder.length() == targetLen) {
                    break;
                }
            }
        }
        String generated = builder.toString();
        System.out.println(generated + " " + generated.length());

    }
}