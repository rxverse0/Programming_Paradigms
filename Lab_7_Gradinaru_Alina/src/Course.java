import java.util.Collections;
import java.util.List;

public class Course {
    private int courseId;
    private int creditPoints;
    private int year;
    private String fullName;
    private List<Student> students;


    public Course(int courseId, int creditPoints, int year, String fullName) {
        this.courseId = courseId;
        this.creditPoints = creditPoints;
        this.year = year;
        this.fullName = fullName;
    }

    public int getCourseId() {
        return courseId;
    }

    public int getCreditPoints() {
        return creditPoints;
    }

    public int getYear() {
        return year;
    }

    public String getFullName() {
        return fullName;
    }

    public List<Student> getStudents() {
        Collections Collection;
        return students == null ? Collections.emptyList() : students;
    }

}
