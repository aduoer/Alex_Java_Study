package qf.task.week04.day01.map_set;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week04.day01
 * @company lpc
 * date 2023/8/7 11:48
 */
public class TestMap {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("lpc","dd");
        map.put("dd","lpc");
        map.put("bxy","lpc");
        System.out.println(map.size());
        System.out.println(map);
        System.out.println(map.containsKey("dd"));
        map.remove("dd");
        System.out.println(map);

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.print(entry.getKey()+"...."+entry.getValue() +"\t");
        }
        System.out.println();
        System.out.println("===================================");
        for (String s : map.keySet()) {
            System.out.print(s+".."+map.get(s)+"\t");
        }
        System.out.println();
        System.out.println("===================================");
        for (String value : map.values()) {
            System.out.print(value+"\t");
        }


    }
}
