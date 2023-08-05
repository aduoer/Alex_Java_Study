package qf.task.week03.day05;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day05
 * @company lpc
 * date 2023/8/4 9:22
 */
public class TestCollection {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        collection.add(1);
        collection.add(2);
        collection.add(3);
        collection.add(4);
        collection.add(5+1+"1");
        System.out.println("集合大小" + collection.size());
        System.out.println("===========toString===========");
        System.out.println(collection);
        System.out.println("===========增强for===========");
        for (Object o : collection) {
            System.out.print(o + "\t");
        }
        collection.remove(1);
        System.out.println();
        System.out.println("===========迭代器===========");
        Iterator iterator = collection.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() + "\t");
        }
        System.out.println();
        collection.clear();
        System.out.println("集合是否为空" + collection.isEmpty());
    }
}
