package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Function<int[], Integer> function = arr -> {
            int min = Integer.MAX_VALUE;
            for (int number : numbers) {
                if (number < min) {
                    min = number;
                }
            }
            return min;

        };
        int min = function.apply(numbers);
        System.out.println(min);
    }
}

//  public static Integer getMinimum(int[] numbers) {
//    int min = Integer.MAX_VALUE;
//  for (int number : numbers) {
//  if (number < min) {
//   number = min;
//   }

// }
// return min;
// }

