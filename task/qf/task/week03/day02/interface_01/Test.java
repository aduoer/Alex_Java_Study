package qf.task.week03.day02.interface_01;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day02
 * @company lpc
 * date 2023/8/1 9:37
 */
public class Test {
    public static void main(String[] args) {
        Student stu = new Student();
        stu.show();
        stu.eat();
        stu.run();

        Runnable run = new Student();
        run.run();
    }
}
