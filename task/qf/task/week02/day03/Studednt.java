package qf.task.week02.day03;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week02.day03
 * @company lpc
 * date 2023/7/26 14:31
 */
public class Studednt {
    public String name;
    public int age;
    public String gender;
    public int score;

    public Studednt() {

    }

    public Studednt(String name, int age, String gender, int score) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.score = score;
    }

    public void sayHi(){
        System.out.println("name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", score=" + score );
    }

    public void study(){
        System.out.println("name=" + name + "在学习");
    }
}
