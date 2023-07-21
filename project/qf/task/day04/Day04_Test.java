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
    private static void demo03() {
        //计算1+2+3+...+100 的和
        int sum = 0;
        for(int i = 1;i <= 100;i++){
            sum +=i;
        }
        System.out.println("1+2+3+...+100 的和为:" + sum);
    }

    private static void demo04() {
        //阶乘
        System.out.println("请输入小于10的数字:");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int factorial = 1;
        for(int i = 1;i <= num;i++){
            factorial *= i;
        }
        System.out.println(num + "的阶乘为:" + factorial);
    }

    private static void demo05() {
        //闰年
        int year = 1500;
        while (year <= 2022){
            if(year%4 == 0 && year%100 != 0 || year%400 == 0) {
                System.out.println(year + "是闰年");
            }
            year++;
        }
    }

    private static void demo06() {
        int i = 0;
        do{
            System.out.println("HelloWorld");
            i++;
        }while(i < 100);
    }

    private static void demo07() {
        char s;
        do {
            System.out.println("抄写代码。。。。");
            System.out.println("检查完成情况");
            System.out.println("请输入是否合格?y/n");
            Scanner sc = new Scanner(System.in);
            s = sc.next().charAt(0);
        }while(s != 'y');
        System.out.println("作业合格!");
    }

    private static void demo09() {
        
    }
    public static void main(String[] args) {
        demo07();
    }
}
