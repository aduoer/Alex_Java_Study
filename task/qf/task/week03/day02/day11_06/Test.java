package qf.task.week03.day02.day11_06;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day02.day11_06
 * @company lpc
 * date 2023/8/1 16:45
 */
public class Test {
    public static void main(String[] args) {
        //局部内部类：
        class Upan implements Usb{
            @Override
            public void server() {
                System.out.println("Upan_OK!");
            }
        }
        Upan upan = new Upan();
        upan.server();

        //匿名内部类：（没有名字的局部内部类）
        Usb upan2 = new Usb(){
            @Override
            public void server() {
                System.out.println("Upan2_OK!");
            }
        };
        upan2.server();


        Usb upan3 = () ->System.out.println("Upan3_OK!");
        upan3.server();


//        Student s = new  Student(){
//            @Override
//            void study() {
//                System.out.println("xx");
//            }
//        };

        Student s = new Student();
        s.study((x) ->System.out.println(x));
    }
}
