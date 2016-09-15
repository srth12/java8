import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsDemoPad {

    public static void main(String[] args) throws IOException {
        class Student {
            String name;
            LocalDate birthDate;

            Student(String name, LocalDate birthDate) {
                this.name = name;
                this.birthDate = birthDate;
            }

            int age() {
                return Period.between(birthDate, LocalDate.now()).getYears();
            }

            @Override
            public String toString() {
                return "Student{" + name + '}';
            }
        }

        List<Student> students = Arrays.asList(
                new Student("Sunit", LocalDate.of(1977,8,7)),
                new Student("Sarthak", LocalDate.of(2008,5,13)),
                new Student("Manish", LocalDate.of(1981,3,29)),
                new Student("Gaurav", LocalDate.of(2012,5,13))
        );

        // get names of all students
        List<String> names = students.stream()
                .map(s -> s.name)
                .peek(System.out::println)
                .collect(Collectors.toList());


        // get list of all students who are born in leap year
        List<Student> leapYearStudents = students.stream()
                  .filter(s -> s.birthDate.isLeapYear() )
                  .collect(Collectors.toList());
        System.out.println(leapYearStudents);

        // get students who are adult
        List<Student> adults = students.stream()
                .filter(s -> s.age() > 18)
                .collect(Collectors.toList());
        System.out.println(adults);

        Files.lines(Paths.get("pom.xml")).forEach(System.out::println);
    }
}
