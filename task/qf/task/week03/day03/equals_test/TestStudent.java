package qf.task.week03.day03.equals_test;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day03
 * @company lpc
 * date 2023/8/2 9:56
 */
public class TestStudent {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        s1.name = "111";
        s2.name = "1211";

        System.out.println(s1.equals(s2));
    }
}
