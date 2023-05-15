package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        }
        int[] indexes = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int valueToReplace = matrix[indexes[0]][indexes[1]];

        List<int[]> correctValues = new ArrayList<>();

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == valueToReplace) {
                    int correctValue = getNearBySum(matrix, r, c, valueToReplace);
                    correctValues.add(new int[]{r, c, correctValue});

                }

            }

        }

        for (int[] correctValue : correctValues) {
            int row = correctValue[0];
            int col = correctValue[1];
            matrix[row][col] = correctValue[2];

        }
        for (int[] arr : matrix) {
            for (int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();

        }

    }

    private static int getNearBySum(int[][] matrix, int r, int c, int valueToReplace) {
        int sum = 0;

        if (isInBounds(matrix, r + 1, c) && valueToReplace != matrix[r + 1][c]) {
            sum += matrix[r + 1][c];
        }
        if (isInBounds(matrix, r - 1, c) && valueToReplace != matrix[r - 1][c]) {
            sum += matrix[r - 1][c];
        }
        if (isInBounds(matrix, r, c - 1) && valueToReplace != matrix[r][c - 1]) {
            sum += matrix[r][c - 1];
        }
        if (isInBounds(matrix, r, c + 1) && valueToReplace != matrix[r][c + 1]) {
            sum += matrix[r][c + 1];
        }

        return sum;
    }

    private static boolean isInBounds(int[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;

    }
}
