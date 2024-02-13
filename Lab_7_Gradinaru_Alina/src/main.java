import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class main {
    public static void main(String[] args) {
        Stream_Exercises exercises = new Stream_Exercises();

        // Test Exercise 1
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(exercises.exercise1(numbers));

        // Test Exercise 2
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);
        int result2 = exercises.exercise2(numbers2);
        System.out.println("Exercise 2 Result: " + result2);

        // Test Exercise 3a
        List<String> strings3a = Arrays.asList("apple", "banana", "orange", "grape", "kiwi");
        Map<Integer, Long> result3a = exercises.exercise3a(strings3a);
        System.out.println("Exercise 3a Result: " + result3a);

        // Test Exercise 3b
        List<String> strings3b = Arrays.asList("apple", "banana", "orange", "grape", "kiwi");
        Map<Integer, Long> result3b = exercises.exercise3b(strings3b);
        System.out.println("Exercise 3b Result: " + result3b);

        // Test Exercise 4
        List<List<String>> listOfLists4 = Arrays.asList(
                Arrays.asList("apple", "banana"),
                Arrays.asList("orange", "kiwi"),
                Arrays.asList("banana", "grape")
        );
        List<String> result4 = exercises.exercise4(listOfLists4);
        System.out.println("Exercise 4 Result: " + result4);

        // Test Exercise 5
        List<Student> students5 = Arrays.asList(
                new Student(1, "Andrei", "Group1", Arrays.asList(new Course(101, 3, 2023, "Math"))),
                new Student(2, "Ioana", "Group2", Arrays.asList(new Course(102, 4, 2023, "Physics")))
        );
        String result5 = exercises.exercise5(students5, "Group1");
        System.out.println("Exercise 5 Result: " + result5);

        // Test Exercise 6
        long result6 = exercises.exercise6();
        System.out.println("Exercise 6 Result: " + result6);

        // Test Exercise 7
        List<Student> students7 = Arrays.asList(
                new Student(1, "Andrei", "Group1", Arrays.asList(new Course(101, 6, 2022, "Math"))),
                new Student(2, "Ioana", "Group2", Arrays.asList(new Course(102, 4, 2022, "Physics")))
        );
        List<Student> result7 = exercises.exercise7(students7);
        System.out.println("Exercise 7 Result: " + result7);

        // Test Exercise 8
        List<Student> students8 = Arrays.asList(
                new Student(1, "Andrei", "Group1", Arrays.asList(new Course(101, 10, 2022, "Math"))),
                new Student(2, "Ioana", "Group2", Arrays.asList(new Course(102, 31, 2022, "Physics")))
        );
        List<Student> result8 = exercises.exercise8(students8);
        System.out.println("Exercise 8 Result: " + result8);

        // Test Exercise 9
        List<Course> courses9 = Arrays.asList(
                new Course(101, 3, 2022, "Math"),
                new Course(102, 4, 2022, "Physics")
        );
        Map<Integer, List<Integer>> result9 = exercises.exercise9(courses9);
        System.out.println("Exercise 9 Result: " + result9);

        // Test Exercise 10
        List<Student> students10 = Arrays.asList(
                new Student(1, "Andrei", "Group1", Arrays.asList(new Course(101, 3, 2022, "Math"))),
                new Student(2, "Ioana", "Group1", Arrays.asList(new Course(102, 4, 2022, "Physics")))
        );
        List<Student> result10 = exercises.exercise10(students10, "Group1");
        System.out.println("Exercise 10 Result: " + result10);

        // Test Exercise 11
        List<Student> students11 = Arrays.asList(
                new Student(1, "Andrei", "Group1", Arrays.asList(new Course(101, 3, 2022, "Math"))),
                new Student(2, "Ioana", "Group1", Arrays.asList(new Course(102, 4, 2022, "Physics")))
        );
        Map<String, Set<String>> result11 = exercises.exercise11(students11);
        System.out.println("Exercise 11 Result: " + result11);

    }
}
