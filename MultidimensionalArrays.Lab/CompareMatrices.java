package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arraysCount = scanner.nextInt();
        int sizeOfArray = scanner.nextInt();
        int[][] firstMatrix = new int[arraysCount][sizeOfArray];

        for (int r = 0; r < arraysCount; r++) {
            for (int c = 0; c < sizeOfArray; c++) {
                firstMatrix[r][c] = scanner.nextInt();
            }
        }
        arraysCount = scanner.nextInt();
        sizeOfArray = scanner.nextInt();

        int[][] secondMatrix = new int[arraysCount][sizeOfArray];
        for (int r = 0; r < secondMatrix.length; r++) {
            for (int c = 0; c < secondMatrix[r].length; c++) {
                secondMatrix[r][c] = scanner.nextInt();
            }

        }
        boolean areEqual = firstMatrix.length == secondMatrix.length
                && areArraysAreEqual(firstMatrix, secondMatrix);

        System.out.println(areEqual ? "equal" : "not equal");
    }

    private static boolean areArraysAreEqual(int[][] firstMatrix, int[][] secondMatrix) {
        boolean areEqual = true;
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int r = 0; r < firstMatrix.length; r++) {
            int[] firstArr = firstMatrix[r];
            int[] secondArr = secondMatrix[r];
            if (firstArr.length != secondArr.length) {
                return false;
            }
            for (int i = 0; i < firstArr.length; i++) {
                int firstNumber = firstArr[i];
                int secondNumber = secondArr[i];
                if (firstNumber != secondNumber) {
                    return false;
                }

            }
        }
        return true;
    }


    public static void printMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }
}
