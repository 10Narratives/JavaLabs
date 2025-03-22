package lab2.calendar;

import java.time.LocalDate;
import static java.time.DayOfWeek.*;
import static java.time.DayOfWeek.of;
import static java.time.LocalDate.of;
import static java.lang.System.out;

public class Calendar {
    private static void printDays(LocalDate date) {
        int value = date.getDayOfWeek().getValue();
        for (int i = 1; i < value + 1; i++)
            out.print("    ");

        while (date.getMonthValue() == LocalDate.now().getMonthValue()) {
            if (date.getDayOfWeek() == SUNDAY)
                out.println();
            out.printf("%4d", date.getDayOfMonth());
            date = date.plusDays(1);
        }
    }

    private static void printDays(LocalDate date, int daysCount) {
        int value = date.getDayOfWeek().getValue();
        for (int i = 1; i < value + 1; i++)
            out.print("    ");

        while (daysCount > 0) {
            if (date.getDayOfWeek() == SUNDAY)
                out.println();
            out.printf("%4d", date.getDayOfMonth());
            date = date.plusDays(1);
            daysCount--;
        }
    }

    private static void showNamesOfWeekDays() {
        for (int i = 0; i < 7; i++)
            out.printf("%4s", of((i + 6) % 7 + 1).toString().substring(0, 3));
        out.println();
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            LocalDate date = of(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), 1);
            showNamesOfWeekDays();
            printDays(date);
        } else {

        }
        out.println();
        LocalDate date = LocalDate.now();
        showNamesOfWeekDays();
        printDays(date, 1);

        out.println();
        showNamesOfWeekDays();
        printDays(date, 2);
        out.println();
        out.println();
        showNamesOfWeekDays();
        out.println();
        printDays(date, 3);
        showNamesOfWeekDays();
        out.println();
        printDays(date, 4);
        showNamesOfWeekDays();
        out.println();
        printDays(date, 5);
        showNamesOfWeekDays();
        out.println();
        printDays(date, 6);
        showNamesOfWeekDays();
        out.println();
        printDays(date, 7);
        showNamesOfWeekDays();
        out.println();
        printDays(date, 8);
        showNamesOfWeekDays();
        out.println();
        printDays(date, 0);
        showNamesOfWeekDays();
        out.println();
        printDays(date, -1);
    }
}
