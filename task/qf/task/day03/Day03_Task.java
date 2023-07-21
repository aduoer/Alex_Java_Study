package qf.task.day03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day03_Task {

    private static void demo1() {
        //1、读入一个整数，表示一个人的年龄。
        // 如果小于6岁，则输出“儿童”，
        // 6岁到13岁，输出“少儿”
        // 14岁到17岁，输出“青少年”；
        // 18岁到35岁输出“青年”；
        // 36岁到50岁，输出“中年”
        // 50岁以上输出“中老年”。
        System.out.println("请输入年龄:");
        Scanner scanner = new Scanner(System.in);
        int age = scanner.nextInt();
        if (age <= 6) {
            System.out.println("儿童");
        } else if (age <= 13) {
            System.out.println("少儿");
        } else if (age <= 17) {
            System.out.println("青少年");
        } else if (age <= 35) {
            System.out.println("青年");
        } else if (age <= 50) {
            System.out.println("中年");
        } else {
            System.out.println("中老年");
        }
    }

    private static void demo2() {
        //计算销售总金额
        //图书批发商店的某本书的零售价是26.5元/本，
        // 如果客户一次性购买100本以上（包括100本），则每本的价格打9折，
        // 如果客户一次性购买500本以上（包括500本），则每本的价格打8折并返回1000元给客户，
        // 请分别计算购买8本、150本、600本的应付金额是多少。要求购买书的数量从控制台输入。
        float price = 26.5f;
        System.out.println("请输入要购买的数量:");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (100 <= num) {
            price = (float) (price * 0.9);
            System.out.println("应付金额为:" + (price * num));
        } else if (500 <= num) {
            price = (float) (price * 0.8);
            System.out.println("应付金额为:" + ((price * num) - 1000));
        }else {
            System.out.println("应付金额为:" + (price * num));
        }
    }

    private static void demo3() {
        //读入一个表示年份的整数，判断这一年是否是闰年。如何判断一个年份是否是闰年：
        //.1 如果这个年份能够被4 整除，且不能被100 整除，则这一年是闰年。例如，1996 年是闰年，而相应的，1993 年就不是闰年。
        //.2 要能被400 整除，也是闰年。例如，2000 年是闰年，1900 年不是闰年。
        System.out.println("请输入年份:");
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        if(year%4 == 0 && year%100 != 0 || year%400 == 0) {
            System.out.println(year + "是闰年");
        } else {
            System.out.println(year + "不是闰年");
        }
    }

    private static void demo4() {
        //代码如下,运行完成之后的结果是:10是偶数。横线处补全代码
//        int a = 10;
//        if (____________) {
//            System.out.println(a + "是偶数");
//        }
        int a = 10;
        if (true) {
            System.out.println(a + "是偶数");
        }
    }

    private static void demo5() {
        //以下代码运行结果？
        //饿了么？
        boolean flag = false;
        int num = 10;
        if (flag){
            num++;
        }
        num++;
        if(num < 11){
            System.out.println("天生我材必有用");
            if (num > 5){
                System.out.println("千金散尽还复来");
            }
        }
        System.out.println("饿了么？");
    }

    private static void demo6() {
        //读入一个整数，如果是1~5 之间，则分别输出5个福娃的名字，否则输出“”。
        System.out.println("请输入数字:");
        Scanner scanner = new Scanner(System.in);
        int fuwa = scanner.nextInt();
        switch(fuwa){
            case 1:
                System.out.println("贝贝");
                break;
            case 2:
                System.out.println("晶晶");
                break;
            case 3:
                System.out.println("欢欢");
                break;
            case 4:
                System.out.println("迎迎");
                break;
            case 5:
                System.out.println("妮妮");
                break;
            default:
                System.out.println("北京欢迎你");
                break;
        }
    }


    private static void demo7() {
     //读入一个整数，输出对应季度。3－5月（春季）6－8月（夏季）9－11月（秋季）12－2月（冬季）
        System.out.println("请输入月份:");
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        if (3 <= month && month <= 5){
            System.out.println("春季");
        }else if (6 <= month && month <= 8){
            System.out.println("夏季");
        }else if (9 <= month && month <= 11){
            System.out.println("秋季");
        }else if ((0 < month && month <= 2) || month == 12){
            System.out.println("冬季");
        }else{
            System.out.println("月份不正确");
        }
    }

    private static void demo8() {
        //以下代码运行结果为？简述原因？
        //输出40，不管if如何执行，最后都会把40赋值给b
        int a = 20;
        if (a == 20) {
            int b = 30;
        }
        int b = 40;
        System.out.println(b);
    }

    private static void demo9(){
        //计算1+2+3+...+100 的和
        int sum = 0;
        for(int i = 1;i <= 100;i++){
            sum +=i;
        }
        System.out.println("1+2+3+...+100 的和为:" + sum);
    }

    private static void demo10(){
        //计算计算1+3+5+...+99的和
        int sum = 0;
        for(int i = 1;i <= 100;i++){
            if(i%2 != 0){
                sum +=i;
            }
        }
        System.out.println("1+3+5+...+99的和为:" + sum);
    }

    private static void demo11(){
        //把10、11 两题用while 循环或do...while 循环改写。
        int sum10 = 0,i = 1;
        while(i <= 100){
            sum10 +=i;
            i++;
        }
        System.out.println("1+2+3+...+100 的和为:" + sum10);
        int sum11 = 0,m = 1;
        while(m <= 100){
            if(m%2 != 0){
                sum11 +=m;
            }
            m++;
        }
        System.out.println("1+3+5+...+99的和为:" + sum11);

    }

    private static void demo12(){
        //读入一个小于10 的整数n，输出它的阶乘n。
        System.out.println("请输入小于10的数字:");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int factorial = 1;
        for(int i = 1;i <= num;i++){
            factorial *= i;
        }
        System.out.println(num + "的阶乘为:" + factorial);
    }

    private static void demo13(){
        //求100 以内所有能被3 整除但不能被5 整除的数字的和。
        int num = 0;
        for(int i = 1;i <= 100;i++){
            if(i%3 == 0 && i%5 != 0){
                num += i;
            }
        }
        System.out.println("能被3整除但不能被5整除的数字的和为:" + num);
    }

    private static void demo14(){
        //编程找出四位整数abcd 中满足 (ab+cd)(ab+cd)=abcd 的数
        for(int i = 1000;i <= 9999;i++){
            int ab = i/100;
            int cd = i%100;
            if((ab+cd) * (ab+cd) == i){
                System.out.println("满足条件的数是:" + i);
            }
        }
    }

    private static void demo15(){
        //输出99 乘法表。
        for(int i = 1;i < 10;i++){
            for(int j = 1;j <= i;j++){
                System.out.print(j + "*" + i + "=" + (i*j) + "\t");
            }
            System.out.println();
        }
    }

    private static void demo16(){
        //计算2000年1月1日到2008年1月1日相距多少天。（注意闰年）
        int day = 0;
        for(int year = 2000;year < 2008;year++){
            if(year%4 == 0 && year%100 != 0 || year%400 == 0) {
                day += 366;
            } else {
                day += 365;
            }
        }
        System.out.println("2000年1月1日到2008年1月1日相距\t" + day + "天");
    }

    private static void demo17() {
        //读入一个整数n，输出如下图形
        //n = 3
        //  *
        //
        // ***
        //
        //*****
        //n = 4
        //   *
        //
        //  ***
        //
        // *****
        //
        //*******
        System.out.println("请输入数字:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 1; i<=n; i++){
            //输出n-i个空格
            for(int j = 1; j<=n-i; j++){
                System.out.print(" ");
            }
            //输出2*i-1个星
            for(int j = 1; j<=2*i-1; j++){
                System.out.print("*");
            }
            //换行
            System.out.println();
        }
    }

    private static void demo18(){
        //求水仙花数。
        //提示：所谓水仙花数，是指一个三位数abc，如果满足a³+b³+c³=abc，则abc是水仙花数。
        int num = 0;
        for(int i = 100;i <= 999;i++){
            int a = i/100;
            int b = i/10%10;
            int c = i%10;
            int res = a*a*a + b*b*b + c*c*c;
            if(res == i){
                num++;
            }
        }
        System.out.println("水仙花数为:" + num);
    }

    private static void demo19(){
//        写一个方法add，两个整数作为参数，返回这两个整数的和。
//        public static int add(int a, int b){
//            return a + b;
//        }
        System.out.println(Day03_Task.add(10,11));
    }

    private static void demo20(){
        //写一个方法，整数n作为参数，输出这个整数的所有因子
        System.out.println("请输入整数:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(Day03_Task.factor(n));
    }

    private static void demo21(){
        //写一个方法，整数n作为参数，输出1+2+3+...+n 的和。
        System.out.println("请输入整数:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(Day03_Task.sum(n));
    }

    private static void demo22(){
        //写一个函数，整数n作为参数，输出n个HelloWorld
        System.out.println("请输入整数:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++){
            Day03_Task.helloworld();
        }
    }

    private static void demo23(){
        //写一个函数，整数n作为参数，输出这个n是几位数
        System.out.println("请输入整数:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        jiwei(n);
    }

    private static void demo24(){
        //验证哥德巴赫猜想：任何一个大于6的偶数，都能分解成两个质数的和。要求输入一个整数，输出这个数能被分解成哪两个质数的和。
        //eg : 14
        //14=3+11
        //14=7+7
        System.out.println("请输入整数:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n > 6 && n % 2 == 0) {
            for (int i = 3; i <= n/2; i+=2) {
                if (isPrime(i) && isPrime(n - i)) {
                    System.out.println("这个数能被分解成\t" + i + "和" + (n - i) + "\t两个质数的和");
                }
            }
        } else {
            System.out.println("输入的" + n + "不是大于6的偶数");
        }

    }
    public static void main(String[] args) {

       demo24();
    }

    //两数相加
    public static int add(int a, int b){
        return a + b;
    }
    //获取n的全部因子
    public static String factor(int n) {
        List list = new ArrayList<Integer>();
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                list.add(i);
            }
        }
        return list.toString();
    }
    //输出1+2+3+...+n 的和
    public static int sum(int n){
        int sum = 0;
        for (int i = 1;i <= n;i++){
            sum += i;
        }
        return sum;
    }
    //输出n个HelloWorld
    public static void  helloworld(){
        System.out.println("HelloWorld");
    }
    //输出n是几位数
    public static void jiwei(int n){
        int w = 0;
        int num = n;
        do{
            w++;
            n = n /10;
        }while(n!=0);
        System.out.println(num + "是" + w + "位数");
    }
    //判断是否为质数
    public static boolean isPrime(int n){
        for(int i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}