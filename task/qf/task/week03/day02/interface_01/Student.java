package qf.task.week03.day02.interface_01;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day02
 * @company lpc
 * date 2023/8/1 9:35
 */
public class Student implements MyInterface,Runnable{
    @Override
    public void show() {
        System.out.println(MyInterface.NAME);
        System.out.println(MyInterface.AGE);
    }

    @Override
    public void eat() {
        System.out.println(MyInterface.NAME+ "吃东西");
    }

    @Override
    public void run() {
        System.out.println("开炮！！");
    }
}
