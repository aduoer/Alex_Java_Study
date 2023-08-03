package qf.task.week03.day04;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day04
 * @company lpc
 * date 2023/8/3 10:24
 */
public class TestBigDecimal {
    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal("10");
        BigDecimal b2 = new BigDecimal("6");
        System.out.println(b1.add(b2).doubleValue());
        System.out.println(b1.subtract(b2).doubleValue());
        System.out.println(b1.multiply(b2).doubleValue());
        System.out.println(b1.divide(b2,3, RoundingMode.HALF_UP).doubleValue());
        System.out.println(b1.remainder(b2).doubleValue());
    }
}
