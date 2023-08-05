package qf.task.week03.day05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day05
 * @company lpc
 * date 2023/8/4 14:49
 */
public class TestFan {
    public static void main(String[] args) {
        Student<String> stu = new Student<>();
        stu.t = "123333";
        String say = stu.say("123");
        System.out.println(say);

        ArrayList<String> arr = new ArrayList<>();
        arr.add("123");
        arr.add("323");
        Iterator<String> iterator = arr.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        stu.hi("xxxxsdadasd",":","2","2",true,123,123.22123);
    }
    private  static class Student<T>{
        T t;
        T say(T t){
            this.t = t;
            T tt = this.t;
            return tt;
        }
        <T> void hi(T...t){
            System.out.println(Arrays.toString(t));
        }
    }
}
