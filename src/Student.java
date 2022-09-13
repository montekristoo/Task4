import java.util.HashSet;
import java.util.Set;

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private boolean eligibleForErasmusScolarship;
    Set<String> universities = new HashSet<>();

    public Student(String firstName, String lastName, int age, boolean eligibleForErasmusScolarship, Set<String> universities) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.eligibleForErasmusScolarship = eligibleForErasmusScolarship;
        this.universities = universities;
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

    public boolean isEligibleForErasmusScolarship() {
        return eligibleForErasmusScolarship;
    }

    public void setEligibleForErasmusScolarship(boolean eligibleForErasmusScolarship) {
        this.eligibleForErasmusScolarship = eligibleForErasmusScolarship;
    }

    public Set<String> getUniversities() {
        return universities;
    }

    public void setUniversities(Set<String> universities) {
        this.universities = universities;
    }
}
