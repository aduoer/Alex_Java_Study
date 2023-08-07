package qf.task.week04.day01.thread;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week04.day01.thread
 * @company lpc
 * date 2023/8/7 17:16
 */
public class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }
   static int count = 100;
    @Override
    public  void run() {
        while(count != 0) {
            if(count < 1) break;
            System.out.println(Thread.currentThread().getName()+"----------------"+"卖了");
            count--;
        }
    }
}
