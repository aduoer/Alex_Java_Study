package qf.task.week03.day02.interface_02;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day02.interface_02
 * @company lpc
 * date 2023/8/1 11:22
 */
public class Computer {
    Usb usb1;
    Usb usb2;

    void work() {
        if (usb1 != null) {
           usb1.server();
        }
        if (usb2 != null) {
            usb2.server();
        }
    }
}
