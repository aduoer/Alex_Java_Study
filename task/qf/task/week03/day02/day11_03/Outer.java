package qf.task.week03.day02.day11_03;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day02.interface_03
 * @company lpc
 * date 2023/8/1 15:16
 */
public class Outer {
    private static String name = " 赵云";
    private int age = 20;
    public void show(){
        System.out.println(this.name+this.age);
    }
    class Inter{
        private static String name = "li云";
        private String address = "北京";
        private String gender = "男";
        static int AGE = 12;
        public void show(){
            System.out.println(Outer.this.name+this.name+this.address+this.gender);
        }
    }
}