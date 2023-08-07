package qf.task.week04.day01.map_set;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week04.day01
 * @company lpc
 * date 2023/8/7 10:21
 */
public class TestTreeSet2 {
    public static void main(String[] args) {
        Comparator<String> comparator = (o1,o2) ->{
                int n1 = o1.length() - o2.length();
                int n2 = o1.compareTo(o2);
                return n1 != 0? n1 :n2;
        };
        TreeSet<String> treeSet = new TreeSet<>(comparator);
        treeSet.add("beijing");
        treeSet.add("shanghai");
        treeSet.add("lvliang");
        treeSet.add("taiyuan");
        treeSet.add("xian");
        System.out.println("treeSet = " + treeSet);
    }
}
