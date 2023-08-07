package qf.task.week04.day01.map_set;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week04.day01
 * @company lpc
 * date 2023/8/7 16:18
 */
public class TestTreeMap {
    public static void main(String[] args) {

        Comparator<String> comparator = new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                int n1 = o1.compareTo(o2);
//                int n1 = o1.age - o2.age;
//                int n2 = o1.name.compareTo(o2.name);
                return n1;
            }
        };
        TreeMap<String,String> treeMap = new TreeMap<>(comparator);
        treeMap.put("12","11");
        treeMap.put("2","22");
        treeMap.put("33","22");
        treeMap.put("14","44");
        System.out.println(treeMap);
    }
}
