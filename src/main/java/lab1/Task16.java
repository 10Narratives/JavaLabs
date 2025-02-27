package lab1;

public class Task16 {
    public static float average(float ...values) {
        float result = 0;
        for (float value : values) {
            result += value;
        }
        return result / values.length;
    }

    public static void main(String[] args) {
        System.out.println(average(10, 20 ,40, 50));
    }
}
