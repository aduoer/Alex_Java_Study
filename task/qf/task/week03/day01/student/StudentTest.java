package qf.task.week03.day01.student;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day01.student
 * @company lpc
 * date 2023/7/31 10:56
 */
public class StudentTest {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
        }
        System.out.println(Student.getStuCount());
    }
}
