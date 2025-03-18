package lab2.creational_patterns.singleton;

import java.util.Scanner;

public class ScannerWrapper {
    private String prompt;
    private Scanner scanner;
    private static ScannerWrapper instance;

    private ScannerWrapper() {
        this.prompt = "[enter] ";
        this.scanner = new Scanner(System.in);
    }

    private ScannerWrapper(String prompt) {
        this.prompt = prompt;
    }

    public static ScannerWrapper getInstance() {
        if (instance == null) {
            instance = new ScannerWrapper();
        }
        return instance;
    }

    public static void setPrompt(String newPrompt) {
        instance.prompt = newPrompt;
    }

    public static void setScanner(Scanner newScanner) {
        instance.scanner = newScanner;
    }

    public String scan() {
        return instance.scanner.nextLine();
    }

}
