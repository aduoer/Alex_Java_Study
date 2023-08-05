package qf.task.week03.day05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day05
 * @company lpc
 * date 2023/8/4 9:59
 */
public class TestList {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        System.out.println("=========迭代器==========");
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + "\t");
        }
        System.out.println();
        System.out.println("=========列表迭代器z==========");
        ListIterator listIterator1 = list.listIterator();
        while (listIterator1.hasNext()){
            System.out.print(listIterator1.nextIndex()+ " =====" +listIterator1.next() + "\t");
        }
        System.out.println("=========列表迭代器n==========");
        ListIterator listIterator2 = list.listIterator();
        while (listIterator2.hasPrevious()){
            System.out.println(listIterator2.previousIndex()+ " =====" +listIterator2.previous());
        }
    }
}
