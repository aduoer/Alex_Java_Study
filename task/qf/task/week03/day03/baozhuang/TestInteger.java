package qf.task.week03.day03.baozhuang;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day03.baozhuang
 * @company lpc
 * date 2023/8/2 11:34
 */
public class TestInteger {
    public static void main(String[] args) {
        Integer i1 =  100;
        Integer i2 =  100;
        System.out.println(i1 == i2);
        Integer i3 =  new Integer(100);


        int s1 = 100;
        System.out.println(Integer.toString(s1,2));

        String name = "222";
        String name1 = "222";
        System.out.println(name == name1);
        System.out.println( Boolean.parseBoolean("xxx"));

    }
}
