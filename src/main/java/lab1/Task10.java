package lab1;

import java.math.BigDecimal;
import java.util.Random;

public class Task10 {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static  String getRandom(int size) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder(size);

        for (int i = 0; i < size; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            builder.append(randomChar);
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        Random random = new Random();
        long randomLong = random.nextLong();

        String string = Long.toString(randomLong, 36);
        System.out.println(string);

        string = getRandom(5);
        System.out.println(string);
    }
}
