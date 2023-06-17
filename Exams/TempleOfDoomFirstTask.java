package Exams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TempleOfDoomFirstTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // Read the tools sequence

        ArrayDeque<Integer> tools = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));


        // Read the substances sequence
        ArrayDeque<Integer> substances = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).forEach(substances::push);


        // Read the challenges sequence
        ArrayDeque<Integer> challenges = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));


        // Process the challenges
        while (!challenges.isEmpty() && !tools.isEmpty() && !substances.isEmpty()) {
            int firstTool = tools.peek();
            int lastSubstance = substances.peek();

            int result = firstTool * lastSubstance;

            if(challenges.contains(result)) {
                // Challenge resolved
                challenges.remove(result);
                tools.poll();
                substances.pop();
            } else {
                // Challenge not resolved
                tools.offer(tools.poll() + 1);
                if (lastSubstance > 1) {
                    substances.pop();
                    substances.push(lastSubstance - 1);
                } else {
                    // Substance becomes empty
                    substances.pop();
                }
            }

            if (tools.isEmpty() || challenges.isEmpty()) {
                // Harry is lost in the temple
                System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
                System.out.print("Substances: ");
                substances.stream().map(String::valueOf)
                        .collect(Collectors.joining(", "));
                substances.forEach(System.out::print);

                return;
            }
        }

        // Harry found the artifact
        System.out.println("Harry is lost in the temple. Oblivion awaits him.");
        System.out.print("Tools: ");
        System.out.println(tools.stream().map(String::valueOf)
                .collect(Collectors.joining(", ")));

        System.out.print("Challenges: ");
        System.out.println(challenges.stream().map(String::valueOf)
                .collect(Collectors.joining(", ")));



    }
}
