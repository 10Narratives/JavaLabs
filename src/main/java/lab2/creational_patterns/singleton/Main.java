package lab2.creational_patterns.singleton;

public class Main {
    public static void main(String[] args) {
        String scan = ScannerWrapper.getInstance().scan();
        System.out.println(scan);
    }
}
