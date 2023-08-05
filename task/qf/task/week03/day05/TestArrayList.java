package qf.task.week03.day05;


import qf.task.week02.day03.Studednt;

import java.util.ArrayList;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day05
 * @company lpc
 * date 2023/8/4 10:11
 */
public class TestArrayList {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        Stuedent S1 =  new Stuedent("李白",11);
        Stuedent S2 = new Stuedent("李白", 11);
        Stuedent S3 =  new Stuedent("李白",11);
        arrayList.add(S1);
    }
    static class Stuedent{
        String name;
        int age;

        public Stuedent() {
        }

        public Stuedent(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Stuedent{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
