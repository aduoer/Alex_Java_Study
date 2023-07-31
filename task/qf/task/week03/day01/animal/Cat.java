package qf.task.week03.day01.animal;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week02.day05
 * @company lpc
 * date 2023/7/28 9:30
 */
public class Cat extends Animal{

    /**
     * 爱好
     */
    String hobby;

    /**
     * 玩
     */
    public void play(){
        System.out.println("猫咪玩毛线");
    }

    public Cat() {
    }

    public Cat(String breed, int age, String gender, String hobby) {
        super(breed, age, gender);
        this.hobby = hobby;
    }

    @Override
    public void eat() {
        System.out.println(super.breed + "猫猫吃哈基米");
    }

    @Override
    public void sleep() {

    }

    /**
     * 信息显示
     */

    public void show(){
        System.out.println("猫咪信息：" + "breed='" + super.breed + '\'' +
                ", age=" + super.age +
                ", gender='" + super.gender + '\'' +
                ", hobby='" + this.hobby );
    }
}
