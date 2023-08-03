package qf.task.week03.day04;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day04
 * @company lpc
 * date 2023/8/3 14:42
 */
public class TestRuntime {
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        System.out.println(r.totalMemory()/1024/1024+"MB");
        System.out.println(r.freeMemory()/1024/1024+"MB");
        System.out.println(r.maxMemory()/1024/1024+"MB");

    }
}
