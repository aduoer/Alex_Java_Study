package qf.task.week02.day05.animal;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week02.day05
 * @company lpc
 * date 2023/7/28 9:33
 */
public class Animal {
    /**
     * 品种
     */
    String breed;

    /**
     * 年龄
     */
    int age;
    /**
     * 性别
     */
    String gender;

    public Animal() {
    }

    public Animal(String breed, int age, String gender) {
        this.breed = breed;
        this.age = age;
        this.gender = gender;
    }

    /**
     * 吃
     */
    public void  eat(){
        System.out.println("动物吃东西");
    }
    /**
     * 睡觉
     */
    public void  sleep(){
        System.out.println("动物在睡觉");
    }
    /**
     * 信息显示
     */
    public void show(){
        System.out.println("动物信息：" + "breed='" + breed + '\'' +
                ", age=" + age +
                ", gender='" + gender);
    }
}
