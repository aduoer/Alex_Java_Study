package qf.task.week03.day04;

import java.util.Calendar;
import java.util.Date;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day04
 * @company lpc
 * date 2023/8/3 11:51
 */
public class TestCalendar {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.YEAR));
        c.set(2022,2,2);
        System.out.println(c.get(Calendar.YEAR));
        Date date = c.getTime();
        System.out.println(date);
    }
}
