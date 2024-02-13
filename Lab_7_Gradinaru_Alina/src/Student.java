import java.util.List;

public class Student {
    private int studentId;
    private String name;
    private String group;
    private List<Course> courses;

    public Student(int studentId, String name, String group, List<Course> courses) {
        this.studentId = studentId;
        this.name = name;
        this.group = group;
        this.courses = courses;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public List<Course> getCourses() {
        return courses;
    }

}
