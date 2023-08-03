package qf.task.week03.day04;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day04
 * @company lpc
 * date 2023/8/3 11:34
 */
public class TestDate {
    public static void main(String[] args) throws Exception {
        Date date = new Date();
        System.out.println(date.toString());
        Date yes = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
        System.out.println(yes.toString());
        System.out.println((System.currentTimeMillis() - 24 * 60 * 60 * 1000));
        SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd HH-mm");
        System.out.println(date);
        System.out.println(sfd.format(System.currentTimeMillis() - 24 * 60 * 60 * 1000));
        System.out.println(sfd.parse("2001-11-28 11-11"));
        System.out.println(sfd.format(sfd.parse("2001-11-28 11-11")));
    }
}
