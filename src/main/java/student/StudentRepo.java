package student;

import universities.Universities;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

public class StudentRepo {
    private static Set<Student> storeStudents = new HashSet<>();
    private static HashMap<Student, ZonedDateTime> registeredStudents = new HashMap<>();

    public void save(Student student) {
        storeStudents.add(student);
    }

    public void getAllStudents() {
        storeStudents.forEach(System.out::println);
    }

    public void getAllRegisteredStudents() {
        registeredStudents.forEach((key, value) -> System.out.println(key + " " + value));
    }

    public void readyForErasmus() {
      storeStudents.forEach(student -> {
          if (student.isEligibleForErasmusScolarship()) {
              registeredStudents.put(student, generateCurrentDate());
          }
      });
    }

    private static ZonedDateTime generateCurrentDate() {
        Instant instant = Instant.now();
        ZoneId z = ZoneId.of("America/Montreal");
        return instant.atZone(z);
    }

    public ArrayList<Student> getStudentsWithGivenUniversity(Universities university) {
        ArrayList<Student> findedStudents = new ArrayList<>();
        storeStudents.forEach(student -> {
            if (student.getUniversities().contains(university)) {
                findedStudents.add(student);
            }
        });
        return findedStudents;
    }

    public Map<String, List<Student>> getUniversityStudents(Universities university) {
        HashMap<String, List<Student>> univerStudents = new HashMap<>();
       storeStudents.forEach(student -> {
           if (student.getUniversities().contains(university))
            univerStudents.computeIfAbsent(university.toString(), k -> new ArrayList<>()).add(student);
       });
       Map<String, List<Student>> unmodifiableUniverStudents = Collections.unmodifiableMap(univerStudents);
       return  unmodifiableUniverStudents;
    }

}
