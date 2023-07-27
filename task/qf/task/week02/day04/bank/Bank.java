package qf.task.week02.day04.bank;

import java.util.Random;
import java.util.Scanner;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week02.day04
 * @company lpc
 * date 2023/7/27 11:01
 */
public class Bank {
    int capacity = 10;
    int size = 0;
    User loginUser;
    int index = 0;
    User[] userList = {};
    boolean state = true;
    /**
     *初始化用户
     */
    public void initial() {
        boolean flag = true;
        expand();
        //添加用户
        while (flag) {
            Scanner sc = new Scanner(System.in);
            System.out.println("是否继续办卡：(1.继续 2.暂停)");
            if (sc.nextInt() == 2) {
                flag = false;
                break;
            }

            if (size == capacity) {
                expand();
            }
            User user = new User();

            String sb = getCardNo();
            user.setCardNo(sb);
            System.out.println("您的卡号是" + sb);

            System.out.println("请输入身份证号：");
            String identity = sc.next();
            user.setIdentity(identity);

            System.out.println("请输入用户名：");
            String usermane = sc.next();
            user.setUsername(usermane);

            System.out.println("请输入密码：");
            String password = sc.next();
            user.setPassword(password);

            System.out.println("请输入手机号：");
            String phone = sc.next();
            user.setPhone(phone);

            System.out.println("请存款：");
            double balance = sc.nextDouble();
            user.setBalance(balance);

            userList[size++] = user;

        }
    }

    /**
     *
     * @return 返回随机生成的卡号
     */
    private static String getCardNo() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder("62");

        // 生成后15位随机数字
        for (int i = 0; i < 16; i++) {
            int digit = random.nextInt(10);
            sb.append(digit);
        }
        return sb.toString();
    }

    /**
     * 扩容User数组
     */
    private void expand() {
        capacity += capacity >> 1;
        User[] newUserList = new User[capacity];
        System.arraycopy(userList, 0,
                newUserList, 0, size);
        userList = newUserList;
    }

    /**
     * 用户登录
     */
    public boolean login(String card, String password) {

        for (int i = 0; i < size; i++) {
            if (userList[i].getCardNo().equals(card) && userList[i].getPassword().equals(password)) {
                loginUser = userList[i];
                System.out.println("欢迎您，" + loginUser.getUsername());
                return true;
            }
        }
        return false;
    }

    /**
     * 展示登录菜单
     */
    public void showMenu() {
        while (state) {
            System.out.println("=============欢迎进入ATM系统================");
            System.out.println("------1.存款 2.取款 3.转账 4.查询余额 5.修改密码 0.退出--------");
            System.out.println("请选择业务：");
            Scanner sc = new Scanner(System.in);
            int state = sc.nextInt();
            switch (state) {
                case 1 -> {
                    System.out.println("请输入存款金额：");
                    double inMoney = sc.nextInt();
                    save(inMoney);
                }
                case 2 -> {
                    System.out.println("请输入取款金额：");
                    double outMoney = sc.nextInt();
                    withDraw(outMoney);
                }
                case 3 -> {
                    System.out.println("请输入转账金额：");
                    double toMoney = sc.nextInt();
                    System.out.println("请输入转账用户：");
                    String toUserName = sc.next();
                    System.out.println("请输入转账用户卡号：");
                    String toCardNo = sc.next();
                    trans(toMoney, toUserName, toCardNo);
                }
                case 4 -> query();
                case 5 -> modifyPassword();
                case 0 -> tuichu();
                default -> System.out.println("输入错误!");
            }
        }
    }

    /**
     * 存款
     */
    private void save(double money) {
        loginUser.setBalance(money + loginUser.getBalance());
        query();
        //System.out.println("当前余额是：" + userList[index].getBalance());
    }

    /**
     * 取款
     */
    private void withDraw(double money) {
        if(money > 0 && money < 50000){
            loginUser.setBalance(loginUser.getBalance() - money);
            query();
        }else {
            System.out.println("金额输入有误");
        }
        //System.out.println("当前余额是：" + userList[index].getBalance());
    }

    /**
     * 转账
     */
    private void trans(double toMoney, String toUserName, String toCardNo) {
        if(toMoney > loginUser.getBalance()){
            System.out.println("余额不足");
        }
        System.out.println("=========用户列表===========");
        for (User user : userList) {
            if(user != null){
                System.out.println(user.getUsername() + "\t" + user.getCardNo());
            }
        }
        if(toCardNo.equals(loginUser.getCardNo())){
            System.out.println("不能给自己转账");
        }
        for (int i = 0; i < size; i++) {
            if (userList[i].getUsername().equals(toUserName) && userList[i].getCardNo().equals(toCardNo)) {
                loginUser.setBalance(loginUser.getBalance() - toMoney);
                userList[i].setBalance(userList[i].getBalance() + toMoney);
                query();
                break;
                //System.out.println("当前余额是：" + userList[index].getBalance());
            }else {
                System.out.println("用户不存在");
                break;
            }
        }
    }

    /**
     * 查余额
     */
    private void query() {
        System.out.println("当前余额是：" + loginUser.getBalance());
    }

    /**
     * 修改密码
     */
    private void modifyPassword() {
        System.out.println("请输入密码：");
        Scanner sc = new Scanner(System.in);
        String newpassword1 = sc.next();
        System.out.println("请确认新密码：");
        String newpassword2 = sc.next();
        if (newpassword1.equals(newpassword2)) {
            loginUser.setPassword(newpassword2);
        }else System.out.println("两次密码不一致");
        System.out.println("修改成功");
    }

    private void tuichu() {
        state = false;
    }

}
