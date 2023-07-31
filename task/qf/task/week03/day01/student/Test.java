package qf.task.week03.day01.student;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day01.student
 * @company lpc
 * date 2023/7/31 15:08
 */
public class Test {
    public static void main(String[] args) {
        Test1.show();
    }
}
class Test1{
    static{
        Test1.count1++;
        Test1.count2++;
    }
    private static Test1 t = new Test1();
    private static int count1;
    private static int count2 = 0;

    public Test1(){
        count1++;
        count2++;
    }

    public static void show(){
        System.out.println(count1);
        System.out.println(count2);
    }
}

