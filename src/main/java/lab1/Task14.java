package lab1;

import java.util.ArrayList;
import java.util.Scanner;

public class Task14 {
    public static ArrayList<ArrayList<Integer>> readMatrix() {
        Scanner in = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        while (in.hasNextLine()) {
            ArrayList<Integer> line = new ArrayList<>();

            String lineSource = in.nextLine();
            String[] lineSourceParts = lineSource.split(" ");
            for (String substring : lineSourceParts) {
                line.add(Integer.parseInt(substring));
            }
            matrix.add(line);
        }
        return matrix;
    }

    public static boolean isMagicSquare(ArrayList<ArrayList<Integer>> matrix) {
        int required = matrix.getFirst().stream().mapToInt(Integer::intValue).sum();
        int rowSum, columnSum, mainSum, secondarySum;
        for (int i = 0; i < matrix.size(); i++) {
            rowSum = 0;
            columnSum = 0;
            mainSum = 0;
            secondarySum = 0;
            for (int j = 0; j < matrix.get(i).size(); j++) {
                rowSum += matrix.get(i).get(j);
                columnSum += matrix.get(j).get(i);
                mainSum += matrix.get(j).get(j);
                secondarySum += matrix.get(matrix.size() - j - 1).get(j);
            }
            if (rowSum != required || columnSum != required || mainSum != required || secondarySum != required) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = readMatrix();
        // System.out.println(matrix);
        System.out.println(isMagicSquare(matrix));
    }
}
