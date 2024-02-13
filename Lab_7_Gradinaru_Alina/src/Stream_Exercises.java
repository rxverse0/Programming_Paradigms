import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;

public class Stream_Exercises {



    // Exercise 1
    public List<Integer> exercise1(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());
    }

    // Exercise 2
    public int exercise2(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> n * n)
                .reduce(0, Integer::sum);
    }

    // Exercise 3a
    public Map<Integer, Long> exercise3a(List<String> strings) {
        return strings.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
    }

    // Exercise 3b
    public Map<Integer, Long> exercise3b(List<String> strings) {
        return strings.stream()
                .collect(Collectors.toMap(String::length, v -> 1L, Long::sum));
    }

    // Exercise 4
    public List<String> exercise4(List<List<String>> listOfLists) {
        return listOfLists.stream()
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    // Exercise 5
    public String exercise5(List<Student> students, String group) {
        return students.stream()
                .filter(student -> student.getGroup().equals(group))
                .map(Student::getName)
                .collect(Collectors.joining(", "));
    }

    // Exercise 6
    public long exercise6() {
        return Stream.generate(() -> (int) (Math.random() * 1000))
                .limit(100000)
                .parallel()
                .mapToLong(n -> n * n)
                .sum();
    }

    // Exercise 7
    public List<Student> exercise7(List<Student> students) {
        return students.stream()
                .filter(student -> student.getCourses()
                        .stream()
                        .anyMatch(course -> course.getCreditPoints() > 5))
                .collect(Collectors.toList());
    }

    // Exercise 8
    public List<Student> exercise8(List<Student> students) {
        return students.stream()
                .filter(student -> student.getCourses()
                        .stream()
                        .mapToInt(Course::getCreditPoints)
                        .sum() > 30)
                .collect(Collectors.toList());
    }

    // Exercise 9
    public Map<Integer, List<Integer>> exercise9(List<Course> courses) {
        return courses.stream()
                .collect(Collectors.toMap(
                        Course::getCourseId,
                        course -> course.getStudents()
                                .stream()
                                .map(Student::getStudentId)
                                .collect(Collectors.toList())
                ));
    }

    // Exercise 10
    public List<Student> exercise10(List<Student> students, String group) {
        return students.stream()
                .filter(student -> student.getGroup().equals(group))
                .sorted(Comparator.comparing(Student::getName))
                .limit(5)
                .collect(Collectors.toList());
    }

    // Exercise 11
    public Map<String, Set<String>> exercise11(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::getGroup,
                        Collectors.flatMapping(
                                student -> student.getCourses()
                                        .stream()
                                        .map(Course::getFullName),
                                Collectors.toSet()
                        )
                ));
    }
}
