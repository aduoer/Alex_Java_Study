package qf.task.week04.day01.map_set;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.TreeSet;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week04.day01
 * @company lpc
 * date 2023/8/7 10:05
 */
public class TestTreeSet {
    public static void main(String[] args) {
        Comparator<Student> comparator = new Comparator<>() {
            @Override
            public int compare(Student o1, Student o2) {
                int n1 = o1.name.compareTo(o2.name);
                int n2 =  o1.age - o2.age;
//                int n1 = o1.age - o2.age;
//                int n2 = o1.name.compareTo(o2.name);
                return n1 != 0?n1 : n2;
            }
        };
        TreeSet<Student> treeSet = new TreeSet<>(comparator);
        Student s1 = new Student("7刘备1",228);
        Student s2 = new Student("2刘备2",128);
        Student s3 = new Student("1刘备3",28);
        treeSet.add(s1);
        treeSet.add(s2);
        treeSet.add(s3);
        System.out.println("个数：" + treeSet.size());
        System.out.println(treeSet.toString());
    }
    static class Student {
        String name;
        int age;

        public Student() {
        }

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
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
