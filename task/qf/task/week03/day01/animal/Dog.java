package qf.task.week03.day01.animal;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week02.day05
 * @company lpc
 * date 2023/7/28 9:26
 */
public class Dog extends Animal{
    /**
     * 毛色
     */
    String furColor;

    /**
     * 跑
     */
    public void  run(){
        System.out.println("狗狗在跑");
    }

    public Dog(){

    }

    public Dog(String breed, int age, String gender, String furColor) {
        super(breed, age, gender);
        this.furColor = furColor;
    }

    @Override
    public void eat() {
        System.out.println(this.breed + "狗狗吃xxx");
    }

    @Override
    public void sleep() {

    }

    /**
     * 信息显示
     */
    public void show(){
        System.out.println("狗狗信息：" + "breed='" + super.breed + '\'' +
                ", age=" + super.age +
                ", gender='" + super.gender + '\'' +
                ", furColor='" + this.furColor);
    }
}
