import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class Person implements Comparable<Person>, Storable {
    private String name;
    private LocalDate birthday;
    private String gender;
    private int height;

    public Person(String name, LocalDate birthday, String gender, int height) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }

    public int getHeight() {
        return height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                ", height=" + height +
                '}';
    }


    /**
     * If this and other are the same object, it returns 0 because an object is always equal to itself.
     * It compares the names of this and other using the compareTo method for String, which returns a negative number if this.name is lexicographically less than other.name, 0 if they are equal, and a positive number if this.name is greater. If the names are not equal, it returns the result of this comparison.
     * If the names are equal, it compares the birthdays in the same way. If the birthdays are not equal, it returns the result of this comparison.
     * If the birthdays are also equal, it compares the genders. If the genders are not equal, it returns the result of this comparison.
     * If the genders are also equal, it compares the heights by subtracting other.height from this.height. This will return a negative number if this.height is less than other.height, 0 if they are equal, and a positive number if this.height is greater. It then returns the result of this comparison.
     **/
    @Override
    public int compareTo(Person other) {
        if (this == other) return 0;

        int nameCompare = this.name.compareTo(other.name);
        System.out.println("Comparing names: " + this.name + " vs " + other.name + ", result: " + nameCompare);
        if (nameCompare != 0) return nameCompare;

        int birthdayCompare = this.birthday.compareTo(other.birthday);
        System.out.println("Comparing birthdays: " + this.birthday + " vs " + other.birthday + ", result: " + birthdayCompare);
        if (birthdayCompare != 0) return birthdayCompare;

        int genderCompare = this.gender.compareTo(other.gender);
        System.out.println("Comparing genders: " + this.gender + " vs " + other.gender + ", result: " + genderCompare);
        if (genderCompare != 0) return genderCompare;

        System.out.println("Comparing heights: " + this.height + " vs " + other.height + ", result: " + (this.height - other.height));
        return this.height - other.height;
    }


    @Override
    public void store(String file) {
        try (PrintWriter writer = new PrintWriter(new File(file))) {
            writer.println(this.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
