package qf.task.week02.day05.person;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week02.day05.person
 * @company lpc
 * date 2023/7/28 10:06
 */
public class personTest {
    public static void main(String[] args) {
        Teacher t = new Teacher();
        t.profession = "计算机";
        t.sayHi();
        t.teach();
        Student s = new Student();
        s.stuNo = "123";
        s.study();
    }
}
