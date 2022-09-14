package student;

import universities.Universities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Student {
    private static int counter = 1;
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private Boolean eligibleForErasmusScolarship;
    Set<Universities> universities = new HashSet<>();

    public Student(String firstName, String lastName, int age, Boolean eligibleForErasmusScolarship, Set<Universities> universities) {
        this.id = counter;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.eligibleForErasmusScolarship = eligibleForErasmusScolarship;
        this.universities = universities;
        counter++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean isEligibleForErasmusScolarship() {
        return eligibleForErasmusScolarship;
    }

    public void setEligibleForErasmusScolarship(Boolean eligibleForErasmusScolarship) {
        this.eligibleForErasmusScolarship = eligibleForErasmusScolarship;
    }

    public Set<Universities> getUniversities() {
        return universities;
    }

    public void setUniversities(Set<Universities> universities) {
        this.universities = universities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", eligibleForErasmusScolarship=" + eligibleForErasmusScolarship +
                ", universities=" + universities +
                '}';
    }
}
