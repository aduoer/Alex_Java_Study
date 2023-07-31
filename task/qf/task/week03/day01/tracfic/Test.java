package qf.task.week03.day01.tracfic;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day01.tracfic
 * @company lpc
 * date 2023/7/31 10:16
 */
public class Test {
    public static void main(String[] args) {
        Master zs = new Master("张三");
       TracficTool bms =  new Car("宝马");
        zs.goHome(bms);
    }
}
