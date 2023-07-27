package qf.task.week02.day04.phone;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week02.day04.phone
 * @company lpc
 * date 2023/7/27 17:21
 */


import java.util.ArrayList;
import java.util.Scanner;

/**
 * 电话本系统设计共可以保存200个联系人，可以使用数组实现。
 * //实现功能:
 * //请输入要选择的功能:
 * //1. 新增一个联系人
 * //2. 查找指定的联系人
 * //3. 查找所有的联系人
 * //4. 修改联系人信息
 * //5. 删除联系人信息
 * //6. 退出系统
 */
public class PhoneBook {
    int capacity = 200;
    int size = 0;
    int id = 1;
    Contacts[] contactsList = new Contacts[capacity];

    public void showMenu() {
        int select = 0;
        boolean flag = true;
        while (flag) {
            System.out.println("=====电话本系统=======");
            System.out.println("1. 新增一个联系人\n" +
                    " 2. 查找指定的联系人\n" +
                    " 3. 查找所有的联系人\n" +
                    " 4. 修改联系人信息\n" +
                    " 5. 删除联系人信息\n" +
                    " 6. 退出系统");
            System.out.println("请选择功能：");
            Scanner sc = new Scanner(System.in);
            select = sc.nextInt();
            switch (select) {
                case 1 -> {
                    initial();

                }
                case 2 -> {
                    System.out.println("请输入名字：");
                    String name = sc.next();
                    for (int i = 0; i < forEachOfName(name).size(); i++) {
                        System.out.println(forEachOfName(name).get(i));
                    }
                }
                case 3 -> {
                    for (int i = 0; i < forEach().size(); i++) {
                        System.out.println(forEach().get(i));
                    }
                }
                case 4 -> {
                    System.out.println("请输入修改的手机号：");
                    String phone = sc.next();
                    if(editContacts(phone)){
                        System.out.println("修改成功");
                    }
                }
                case 5 -> {
                    System.out.println("======联系人列表========");
                    for (int i = 0; i < forEach().size(); i++) {
                        System.out.println(forEach().get(i));
                    }
                    System.out.println("请输入要删除的编号：");
                    int id = sc.nextInt();
                   if(delContacts(id)){
                       System.out.println("删除成功");
                   }
                }
                case 6 -> {
                    flag = false;

                }
                default -> {
                    System.out.println("输入有误");
                }
            }
        }
    }

    //1、新增一个联系人，联系人的编号从1开始自动增长，姓名，性别，年龄，手机号，身份证号由用户从控制台录入
    public void initial() {
        boolean flag = true;
        //添加用户
        while (flag) {
            Scanner sc = new Scanner(System.in);
            System.out.println("是否继续添加：(1.继续 2.暂停)");
            if (sc.nextInt() == 2) {
                flag = false;
                break;
            }
            if (size == capacity) {
                expand();
            }

            Contacts contacts = new Contacts();
            contacts.setId(id++);

            System.out.println("请输入姓名：");
            String name = sc.next();
            contacts.setName(name);


            System.out.println("请输入性别：");
            String sex = sc.next();
            contacts.setSex(sex);

            System.out.println("请输入年龄：");
            int age = sc.nextInt();
            contacts.setAge(age);

            System.out.println("请输入手机号：");
            String phone = sc.next();
            contacts.setPhoneNum(phone);

            System.out.println("请输入身份证号：");
            String idCard = sc.next();
            contacts.setIdCard(idCard);

            contactsList[size++] = contacts;
        }
    }

    /**
     * 扩容User数组
     */
    private void expand() {
        capacity += capacity >> 1;
        Contacts[] newContactsList = new Contacts[capacity];
        System.arraycopy(contactsList, 0,
                newContactsList, 0, size);
        contactsList = newContactsList;
    }

    //2、按照姓名查找符合条件的所有的联系人(有可能有联系人同名情况，如果同名，全部列出)
    public ArrayList<Object> forEachOfName(String name) {
        ArrayList<Object> arrayList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            if (contactsList[i].getName().equals(name)) {
                arrayList.add(contactsList[i]);
            }
        }
        return arrayList;
    }

    //3、查询所有的联系人
    public ArrayList<Object> forEach() {
        ArrayList<Object> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrayList.add(contactsList[i]);
        }
        return arrayList;
    }
    //4、选择一个联系人修改信息

    public boolean editContacts(String phoneNum) {
        for (int i = 0;  i < size;  i++) {
            if(contactsList[i].getPhoneNum().equals(phoneNum)){
                System.out.println("查有此人，继续操作");

                Scanner sc = new Scanner(System.in);
                System.out.println("请输入姓名：");
                String name = sc.next();

                System.out.println("请输入性别：");
                String sex = sc.next();

                System.out.println("请输入年龄：");
                int age = sc.nextInt();

                contactsList[i].setName(name);
                contactsList[i].setSex(sex);
                contactsList[i].setAge(age);

                return true;
            }
        }

        return false;
    }

    //5、可以把无效的联系人删除
    public boolean delContacts(int id) {
        for (Contacts contacts : contactsList) {
            if (contacts.getId() == id) {
                contacts.setId(0);
                contacts.setName(null);
                contacts.setSex(null);
                contacts.setAge(0);
                contacts.setPhoneNum(null);
                contacts.setIdCard(null);
                return true;
            }
        }
        return false;
    }

}
