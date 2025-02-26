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

        short num1 = (short) input1;
        short num2 = (short) input2;

        int sum = (num1 & 0xFFFF) + (num2 & 0xFFFF);
        int difference = (num1 & 0xFFFF) - (num2 & 0xFFFF);
        int product = (num1 & 0xFFFF) * (num2 & 0xFFFF);
        int quotient = (num1 & 0xFFFF) / (num2 & 0xFFFF);
        int remainder = (num1 & 0xFFFF) % (num2 & 0xFFFF);

        // Вывод результатов
        System.out.println(sum & 0xFFFF);
        System.out.println(difference & 0xFFFF);
        System.out.println(product & 0xFFFF);
        System.out.println(quotient & 0xFFFF);
        System.out.println(remainder & 0xFFFF);
    }
}
