package qf.task.week03.day03;

import java.util.Arrays;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day03
 * @company lpc
 * date 2023/8/2 14:56
 */
public class TestString {
    public static void main(String[] args) {
        String s1 = " Java is best Java";
        System.out.println(s1.charAt(1));

        System.out.println(s1.contains("Java"));

        System.out.println(Arrays.toString(s1.toCharArray()));

        System.out.println(s1.indexOf("Java", 1));

        System.out.println(s1.length());

        System.out.println(s1.trim());

        System.out.println(s1.startsWith("J"));

        System.out.println(s1.endsWith("a"));

        System.out.println(s1.replace("Java", "java"));

        System.out.println(Arrays.toString(s1.split(" +")));

        System.out.println(s1.equals(s1));

        System.out.println(s1.compareTo("JavaJJ"));
    }
}
