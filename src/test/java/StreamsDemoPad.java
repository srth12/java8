import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
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
        }

        List<Student> students = Arrays.asList(
                new Student("Sunit", LocalDate.of(1977,8,7)),
                new Student("Manan", LocalDate.of(2008,5,13)),
                new Student("Leap Year Person", LocalDate.of(2012,5,13))
        );

        Stream<String> namesStream = students.stream().map(s -> s.name);
        List<String> names = namesStream.collect(Collectors.toList());
        System.out.println(names);

//        List<Student> leapYearStudents = students.stream()
//                  .filter(s -> s.birthDate.isLeapYear() )
//                  .collect(Collectors.toList());

//        Files.lines(Paths.get("pom.xml")).forEach(System.out::println);
    }
}
