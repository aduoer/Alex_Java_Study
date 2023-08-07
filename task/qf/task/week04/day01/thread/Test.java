package qf.task.week04.day01.thread;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week04.day01.thread
 * @company lpc
 * date 2023/8/7 17:22
 */
public class Test {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread("窗口1");
        MyThread thread2 = new MyThread("窗口2");
        MyThread thread3 = new MyThread("窗口3");
        MyThread thread4 = new MyThread("窗口4");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }
}
