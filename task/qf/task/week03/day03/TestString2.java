package qf.task.week03.day03;

import java.util.Arrays;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day03
 * @company lpc
 * date 2023/8/2 15:24
 */
public class TestString2 {
    public static void main(String[] args) {
        //需求：已知String str = "this is a text";
        //将str中的单词单独获取出来
        //将str中的text替换为practice
        //在text前面插入一个easy
        //将每个单词的首字母改为大写
        String str = "this is a text";
        String[] s = str.split(" ");
        System.out.println(Arrays.toString(s));

        System.out.println(str.replace("text","practice"));

        System.out.println(str.replace("text", "easy text"));

        for (String s1 : s) {
            char c = s1.charAt(0);
            System.out.println(Character.toUpperCase(c) + s1.substring(1));
        }
    }
}
