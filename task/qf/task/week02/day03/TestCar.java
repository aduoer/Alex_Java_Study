package qf.task.week02.day03;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week02.day03
 * @company lpc
 * date 2023/7/26 17:17
 */
public class TestCar {
    public static void main(String[] args) {
        Car car = new Car();
        car.dirve();

        Car [] c = new Car[3];
        c[0] = car;
        c[1] = car;
        c[2] = car;

        for (Car m : c) System.out.println("\t" + m.toString());
    }
}
