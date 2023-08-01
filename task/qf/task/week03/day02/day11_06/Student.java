package qf.task.week03.day02.day11_06;

import java.util.function.Consumer;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day02.day11_06
 * @company lpc
 * date 2023/8/1 16:58
 */
public  class Student {
    void study(Consumer<String> consumer){
       consumer.accept("123");
    }
}
