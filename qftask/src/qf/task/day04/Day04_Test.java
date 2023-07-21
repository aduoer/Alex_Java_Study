package qf.task.day04;

import java.util.Scanner;

public class Day04_Test {
    static final int MAX = 100;
    private static void demo01() {

        Scanner input = new Scanner(System.in);
        System.out.println("请输入x的值");
        int x = input.nextInt();
        System.out.println("请输入y的值");
        int y = input.nextInt();
        System.out.println("请输入z的值");
        int z = input.nextInt();
        int max = x;
//        max = max < y ? y : max;
//        max = max < z ? z : max;
        if (max < y) {
            max = y;
        }
        if (max < z) {
            max = z;
        }
        System.out.println("最大值:" + max);
    }
    private static void demo02() {
        System.out.println(MAX);
    }
    public static void main(String[] args) {
        demo02();
    }
}
