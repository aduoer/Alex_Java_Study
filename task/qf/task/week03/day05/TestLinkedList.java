package qf.task.week03.day05;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day05
 * @company lpc
 * date 2023/8/4 11:22
 */
public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast("1");
        list.addLast("123");



        list.remove("123");

        System.out.println(list);
        Iterator it = list.iterator();
        for (Object o : list) {
            it.remove();
            System.out.println(o);
        }

        System.out.println(list);
    }
}
