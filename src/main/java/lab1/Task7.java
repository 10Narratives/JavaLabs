package lab1;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input1 = scanner.nextInt();
        int input2 = scanner.nextInt();

        if (input1 < 0 || input1 > 65535 || input2 < 0 || input2 > 65535) {
            return;
        }

        int sum = (input1 & 0xFFFF) + (input2 & 0xFFFF);
        int difference = (input1 & 0xFFFF) - (input2 & 0xFFFF);
        int product = (input1 & 0xFFFF) * (input2 & 0xFFFF);
        int quotient = (input1 & 0xFFFF) / (input2 & 0xFFFF);
        int remainder = (input1 & 0xFFFF) % (input2 & 0xFFFF);

        // Вывод результатов
        System.out.println(sum & 0xFFFF);
        System.out.println(difference & 0xFFFF);
        System.out.println(product & 0xFFFF);
        System.out.println(quotient & 0xFFFF);
        System.out.println(remainder & 0xFFFF);
    }
}
