package qf.task.week03.day02.interface_02;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day02.interface_02
 * @company lpc
 * date 2023/8/1 11:24
 */
public class Test {
    public static void main(String[] args) {
//        Mouse mouse = new Mouse();
//        Upan upan = new Upan();
        Usb mouse = new Mouse();
        Usb upan = new Upan();
        Computer computer = new Computer();

//        computer.usb1 = mouse;
        computer.usb2 = upan;

        computer.work();
    }
}
