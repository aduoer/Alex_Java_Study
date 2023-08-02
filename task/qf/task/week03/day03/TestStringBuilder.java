package qf.task.week03.day03;

import java.util.Arrays;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day03
 * @company lpc
 * date 2023/8/2 16:10
 */
public class TestStringBuilder {
    public static void main(String[] args) {
        String s1="abc";
        String s2="xyz";
        String s3=s1+s2;
        String s4="abc"+"xyz";
        String s5="abcxyz";
        System.out.println(s3==s4);
        System.out.println(s4==s5);
    }
}
