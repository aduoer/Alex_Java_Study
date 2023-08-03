package qf.task.week03.day04;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day04
 * @company lpc
 * date 2023/8/3 9:33
 */
public class TestRege {
    public static void main(String[] args) {
        String s = "我我我我喜喜喜喜喜喜欢欢java";
        System.out.println(s.replaceAll("(.)\\1+","$1"));
        System.out.println(s.replaceAll("(.)+","$1"));
    }
}
