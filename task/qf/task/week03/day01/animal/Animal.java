package qf.task.week03.day01.animal;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week02.day05
 * @company lpc
 * date 2023/7/28 9:33
 */
public abstract class Animal {
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
    public abstract void  eat();
    /**
     * 睡觉
     */
    public abstract void  sleep();
    /**
     * 信息显示
     */
    public abstract void show();
}
