package qf.task.week03.day01.tracfic;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day01.tracfic
 * @company lpc
 * date 2023/7/31 10:13
 */
public class Car extends TracficTool{

    public Car() {
    }

    public Car(String brand) {
        super(brand);
    }

    @Override
    public void run() {
        System.out.println(super.getBrand() + "车回家");
    }
}
