package qf.task.day04;

import java.util.Random;
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

    private static void demo08() {
        System.out.print("请输入数字:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            System.out.println(i+ "+" + (n-i) + "=" + n);
        }
    }

    private static void demo09() {
        int i = 10;
        for (;true;) {
            System.out.println(1);
        }
    }

    private static void demo10() {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        do {
            count++;
            System.out.println("小张开始跑第" + count + "圈");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("小张跑完第" + count + "圈");
            System.out.println("小张还能坚持吗?y/n");
            char c = sc.next().charAt(0);
            if (c != 'y'){
                break;
            }
        }while (count < 10);
        System.out.println("小张一共跑了" + count + "圈");
    }

    private static void demo11() {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        do {
            count++;
            System.out.println("小张开始跑第" + count + "圈");
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
            System.out.println("小张跑完第" + count + "圈");
            System.out.println("小张要喝水吗?y/n");
            char c = sc.next().charAt(0);
            if (c != 'y'){
                continue;
            }
            System.out.println("喝水");
        }while (count < 10);
        System.out.println("小张一共跑了" + count + "圈");
    }

    private static void demo12() {
        int count = 0;
        for (int i = 0; i < 100; i++) {
            if(i%7 == 0 || i%10 == 7 || i/10 == 7){
                continue;
            }
            count++;
            System.out.print(i + "\t");
            if(count % 6 == 0){
                System.out.println();
            }
        }
    }

    private static void demo13() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 1; i <= 3;i++){
            int sum = 0;
            for (int j = 1; j <= 5; j++) {
                System.out.println("请输入第" + i + "个班第" + j + "个同学的成绩:");
                int score = scanner.nextInt();
                sum += score;
            }
            double avg = sum/5.0;
            System.out.printf("第" + i + "个班的平均成绩是:%.2f",avg);
            System.out.println();
        }
    }

    private static void demo14() {
        for(int i = 1; i <= 9;i++){
            for(int j = 1;j <= i;j++){
                System.out.print(j + "*" + i + "=" + (j * i) + "\t");
            }
            System.out.println();
        }
    }

    private static void demo15() {
        System.out.println("请输入数字:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int m = 1; m <= (n-i); m++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2*i-1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void demo16(){
        int count = 100;
        for (int i = 0; i <= 20; i++) {
            for (int j = 0; j <= 33; j++) {
                int z = 100-i-j;
                if(15*i + 9*j + z  == 300){
                    System.out.println("公鸡" + i + "只\t" + "母鸡" + j + "只\t" + "小鸡" + (count - i - j) + "只");
                }
            }
        }
    }

    private static void demo17() {
        for (int i = 2; i <= 100; i++){
            boolean flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag){
                System.out.println(i);
            }
        }
    }

    private static void demo18() {
        Scanner scanner = new Scanner(System.in);
        boolean state = true;
        do {
            System.out.println("==========欢迎使用ATM自助服务==========");
            System.out.println("1:开户 2:存款 3:取款 4:转账 5:查询余额 6:修改密码 0:退出");
            System.out.println("================================");
            System.out.println("请输入操作号:");
            int n = scanner.nextInt();
            switch (n){
                case 1:
                    System.out.println("---执行开户功能---");
                    break;
                case 2:
                    System.out.println("---执行存款3功能---");
                    break;
                case 3:
                    System.out.println("---执行取款功能---");
                    break;
                case 4:
                    System.out.println("---执行转账功能---");
                    break;
                case 5:
                    System.out.println("---执行查询余额功能---");
                    break;
                case 6:
                    System.out.println("---执行修改密码功能---");
                    break;
                case 0:
                    System.out.println("---退出---");
                    state = false;
                    break;
                default:
                    System.out.println("输入有误请重新输入:");
            }
        } while (state);
    }

    private static void demo19(){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        char answer;
        do {
            System.out.println("=====欢迎=====");
            System.out.println("1:石头 2:剪刀 3:布");
            System.out.println("===================");
            System.out.println("请选择数字:");
            int num = scanner.nextInt();
            int comnum =  random.nextInt(1,4);
            if(num == comnum){
                System.out.println("平局");
            } else if (num == 1 && comnum == 2 || num == 2 && comnum == 3 || num == 3 && comnum == 1) {
                System.out.println("你赢了!");
            }else{
                System.out.println("你输了!");
            }
            System.out.println("==========");
            System.out.println("是否再来一局？y/n");
            Scanner sc = new Scanner(System.in);
             answer = sc.next().charAt(0);
        } while (answer == 'y');
        System.out.println("游戏结束");
    }

    public static void main(String[] args) {
        /*
        System.out.println("请输入数字");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if(Day04_Test.isHui(num)){
            System.out.println(num + "是回文数");
        }else{
            System.out.println("不是回文数");
        }
        */
        //回文数测试
//        demo19();
    }
    //判断是否为闰年
    static boolean isRun(int year) {
        if(year%4 == 0 && year%100 != 0 || year%400 == 0) {
            return true;
        }
        return false;
    }
    //判断是否为回文数
    static boolean isHui(int num) {
        if(10000 >= num || num >= 99999){
            return false;
        }
        if(num%10 == num/10000 && num%100/10 == num%10000/1000) {
            return true;
        }
        return false;
    }

}
