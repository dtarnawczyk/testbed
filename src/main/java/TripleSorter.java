import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class TripleSorter {
    @Test
    public void basicTest() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(23, 88, "David Goodman"));
        students.add(new Student(25, 82, "Mark Rose"));
        students.add(new Student(22, 90, "Jane Doe"));
        students.add(new Student(25, 90, "Jane Dane"));
        assertEquals("Jane Doe,Jane Dane,David Goodman,Mark Rose",
                TripleSorter.sort(students));
    }

    public static String sort(List<Student> students) {
        return students.stream().sorted((s1, s2) -> {
            if(Integer.compare(s2.getGpa(), s1.getGpa()) != 0){
                return Integer.compare(s2.getGpa(), s1.getGpa());
            } else if( Integer.compare(s1.getAge(),s2.getAge()) != 0){
                return Integer.compare(s1.getAge(),s2.getAge());
            } else
                return s2.getFullName().compareTo(s1.getFullName());
            }).map(Student::getFullName).collect(Collectors.joining(","));
    }

    class Student {

        private int age;
        private int gpa;
        private String fullName;

        Student(int age, int gpa, String fullName){
            this.age = age;
            this.gpa = gpa;
            this.fullName = fullName;
        }

        int getGpa(){
            return gpa;
        }

        int getAge(){
            return age;
        }
        String getFullName(){
            return fullName;
        }
    }
}
