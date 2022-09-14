import com.github.javafaker.Faker;
import student.Student;
import student.StudentRepo;
import universities.Universities;

import java.sql.SQLOutput;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

public class Main {
    static Faker faker = new Faker();
    static StudentRepo studentRepo = new StudentRepo();

    public static void main(String[] args) {
        generateStudents();
        printAll();
        getStudentsWithGivenUniver(Universities.OXFORD);
        getRegisteredStudents();
        getUniversityStudents(Universities.JOHNHOPKINS);
    }

    private static void addStudents(Set<Universities> universities) {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        int age = faker.number().numberBetween(18, 25);
        Boolean eligible = faker.random().nextBoolean();
        Student student = new Student(firstName, lastName, age, eligible, universities);
        studentRepo.save(student);
    }

    private static void generateStudents() {
        Random random = new Random();
        int lengthOfUnivers = Universities.values().length;
        for (int i = 0; i < 15; i++) {
            int numberOfUniver = random.nextInt((lengthOfUnivers - 1) + 1) + 1;
            Set<Universities> universities = new HashSet<>();
            for (int j = 0; j < numberOfUniver; j++) {
                int university = random.nextInt( lengthOfUnivers);
                int k = 0;
                for (Universities u : Universities.values()) {
                    if (k == university) {
                        universities.add(u);
                    }
                    k++;
                }
            }
            addStudents(universities);
        }
    }

    private static void printAll() {
        System.out.println("-----> ALL STUDENTS: ");
        studentRepo.getAllStudents();
        System.out.println();
    }

    private static void getStudentsWithGivenUniver(Universities university) {
        System.out.println("-----> STUDENTS WITH GIVEN UNIVERSITY: ");
        ArrayList<Student> students = studentRepo.getStudentsWithGivenUniversity(university);
        students.forEach((student -> {
            System.out.println(student.toString());
        }));
        System.out.println();
    }

    private static void getRegisteredStudents() {
        System.out.println("-----> REGISTERED STUDENTS: ");
        studentRepo.readyForErasmus();
        studentRepo.getAllRegisteredStudents();
        System.out.println();
    }

    private static void getUniversityStudents(Universities university) {
        System.out.println("-----> UNIVERSITY STUDENTS: ");
        Map<String, List<Student>> getter = Collections.unmodifiableMap(studentRepo.getUniversityStudents(university));
        getter.forEach((key, value) -> {
            System.out.println(key);
            value.forEach(student -> {
                System.out.println(student.toString());
            });
        });
    }
}
