package qf.task.week02.day04.phone;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week02.day04.phone
 * @company lpc
 * date 2023/7/27 17:22
 */
public class Contacts {
    //1开始自动增长，姓名，性别，年龄，手机号，身份证号
    private int id;
    private String name;
    private String sex;
    private int age;
    private String phoneNum;
    private String idCard;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Contacts() {
    }

    public Contacts(int id, String name, String sex, int age, String phoneNum, String idCard) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phoneNum = phoneNum;
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", phoneNum='" + phoneNum + '\'' +
                ", idCard='" + idCard + '\'' +
                '}';
    }
}
