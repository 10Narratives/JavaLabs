package lab1;

import java.util.Random;

public class Task10 {
    public static void main(String[] args) {
        Random random = new Random();
        long randomLong = random.nextLong();

        String string = Long.toString(randomLong, 36);
        System.out.println(string);
    }
}
