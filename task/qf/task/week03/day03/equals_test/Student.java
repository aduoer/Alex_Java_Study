package qf.task.week03.day03.equals_test;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day03
 * @company lpc
 * date 2023/8/2 9:55
 */
public class Student {
    String name;
    int age;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (obj instanceof Student) {
            Student s = (Student) obj;
            if (this.name.equals(s.name)
                    && this.age == s.age) return true;
        }
        return false;
    }
}
