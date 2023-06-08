package DefiningClasses.OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int numberOfPeople=Integer.parseInt(scanner.nextLine());

        List<Person> people=new ArrayList<>();

        for (int i = 0; i <numberOfPeople ; i++) {
            String[] personData=scanner.nextLine().split(" ");
            String firstName=personData[0];
            int age=Integer.parseInt(personData[1]);
            Person person=new Person(firstName,age);
            people.add(person);

        }
        people.stream().filter(person -> person.getAge()>30).sorted(Comparator.comparing(Person::getName))
                .forEach(System.out::println);
    }
}
