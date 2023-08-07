package qf.task.week04.day01.map_set;

import org.w3c.dom.ls.LSInput;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week04.day01
 * @company lpc
 * date 2023/8/7 9:21
 */
public class TestLinkedHashSet {
    public static void main(String[] args) {
        LinkedHashSet<Student> list = new LinkedHashSet<>();
        Student s1 = new Student("刘备1",28);
        Student s2 = new Student("刘备2",28);
        Student s3 = new Student("刘备3",28);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(new Student("刘备3",28));
        System.out.println("个数：" + list.size());
        System.out.println(list.toString());
    }
    static class Student{
        String name;
        int  age;

        public Student() {
        }

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return age == student.age && Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
