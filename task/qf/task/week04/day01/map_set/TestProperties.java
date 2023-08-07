package qf.task.week04.day01.map_set;

import java.util.Properties;
import java.util.Set;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week04.day01
 * @company lpc
 * date 2023/8/7 16:26
 */
public class TestProperties {
    public static void main(String[] args) {
        Properties properties = new Properties();

        properties.put("username","zhangsan");
        properties.put("age","13");

        System.out.println(properties);

        Set<String> strings = properties.stringPropertyNames();
        for (String string : strings) {
            System.out.println(string+"..."+properties.getProperty(string));
        }

    }
}
