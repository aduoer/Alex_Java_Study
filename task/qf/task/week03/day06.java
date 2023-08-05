package qf.task.week03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.SimpleTimeZone;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03
 * @company lpc
 * date 2023/8/5 9:21
 */
public class day06 {

    public static void demo01(){
        //声明一个char型的数组，在此数组的单元格中放入”我爱你”三个字符，
        // 然后使用循环 将它反序输出。如”你爱我”
        char[] c = new char[]{'我','爱','你'};
        for (int i = c.length - 1; i >= 0 ; i--) {
            System.out.println(c[i]);
        }
    }

    public static void demo02(){
        //声明一个int型的数组，循环接收8个学生的成绩，
        //计算这8个学生的总分及平均分、最高分和最低分
        int[] scores = new int[8];
        int max =  0,min = max,sum = 0;
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < scores.length; i++) {
            scores[i] = sc.nextInt();
            sum += scores[i];
            max = Math.max(max,scores[i]);
            min = Math.min(min,scores[i]);
        }
        System.out.println("平均分：" + sum/8);
        System.out.println("最高分：" + max);
        System.out.println("最低分：" + min);
    }

    public static boolean demo03(String str){
        //写一个方法判断一个字符串是否对称
            char[] c = str.toCharArray();
            int i = c.length - 1;
            for (int j = 0; j < c.length >> 1; i--,j++) {
                if(c[i] != c[j]) return false;
            }
            return true;
    }

    private static void demo04() {
        System.out.println("本次消费18000元，请问用微信还是支付宝？");
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        try {
            isGou(money);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("没钱就去洗盘子");
        }
    }
    private static void isGou(int money) throws Exception{
         if(money < 18000){
            System.out.println("哥们，怎么没钱呢？");
            throw  new Exception();
         }else {
             System.out.println("您成功消费18000");
         }
    }

    public static void randomeStr(int length){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            sb.append(randomChar);
        }
        System.out.println(sb);
    }

    public static int howMuchChar(String str){
        //编写程序，统计出字符串“I wish you become better and better”中字母e的出现次数
        int count = 0;
        for (char c : str.toCharArray()) {
            if(c == 'e') count++;
        }
        return count;

    }

    public static int whenDay(String date1,String date2) throws ParseException {
        //计算某年、某月、某日和某年、某月、某日之间的间隔天数，
        // 要求年月日通过main方法的参数传递到程序中
        int day = 0;
        try {
            SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");
            Date sfd_Date1 = sfd.parse(date1);
            Date sfd_Date2 = sfd.parse(date2);
            day = (int) (Math.abs((sfd_Date1.getTime() - sfd_Date2.getTime()))/(1000*60*60*24));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return day;
    }
    public static void main(String[] args) throws ParseException {
//        System.out.println(demo03("abvvcfba"));
//        randomeStr(4);
//        int i = howMuchChar("I wish you become better and better");
//        System.out.println(i);

        String str1 = "2021-5-21";
        String str2 = "2023-8-5";

        System.out.println(whenDay(str1,str2)+ "天");

    }


}
