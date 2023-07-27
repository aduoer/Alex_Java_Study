package qf.task.week02.day04.bank;

import java.util.Scanner;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week02.day04
 * @company lpc
 * date 2023/7/27 11:25
 */
public class BankTest {


    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.initial();

        System.out.println("======请登录========");
        System.out.println("请输入卡号：");
        Scanner sc = new Scanner(System.in);
        String card = sc.next();
        System.out.println("请输入密码：");
        String password = sc.next();
        if(bank.login(card,password)) bank.showMenu();
        else System.out.println("卡号或密码错误");

    }
}
