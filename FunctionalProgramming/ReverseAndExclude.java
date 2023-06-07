package FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
       List<Integer>list= Arrays.stream(scanner.nextLine().split("\\s+"))
               .map(Integer::parseInt).collect(Collectors.toList());

       int magicNumber=Integer.parseInt(scanner.nextLine());

        Collections.reverse(list);

        list.removeIf(number->number % magicNumber==0);

        list.forEach(n-> System.out.print(n+" "));
    }

}
