package qf.task.week03.day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day05
 * @company lpc
 * date 2023/8/4 16:17
 */
public class TestArrayToList {

    public static void main(String[] args) {
        interface person1{
            void nan();
        }
        interface person{
            void nan();
        }

        //局部
        class nan{
            public void nan() {
                System.out.println("nan");
            }
        }
        nan nan = new nan();
        nan.nan();

        //是不是匿名内部类 为什么只实现person接口
        nan nan1 = new nan () {

        };

        person nan2 = () -> System.out.println("nan");
    }

}