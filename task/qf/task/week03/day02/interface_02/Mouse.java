package qf.task.week03.day02.interface_02;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day02.interface_02
 * @company lpc
 * date 2023/8/1 11:22
 */
public class Mouse implements Usb{
    @Override
    public void server() {
        System.out.println("鼠标连接成功，开始工作");
    }
}
