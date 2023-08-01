package qf.task.week03.day02.day11_04;

import qf.task.week03.day02.day11_04.Outer.Inter;
/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day02.interface_03
 * @company lpc
 * date 2023/8/1 15:18
 */
public class Test {
    public static void main(String[] args) {
        Outer out = new Outer();
        out.show();

        System.out.println("==================");
        Inter inter = new Inter();
        inter.show();
    }
}
