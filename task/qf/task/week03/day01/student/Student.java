package qf.task.week03.day01.student;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day01.student
 * @company lpc
 * date 2023/7/31 10:52
 */
public class Student{
    private String name;
    private int age;
    private String gender;
    private double score;
    /**
     * 静态属性：整个类共有的属性
     */
    private static int stuCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public static int getStuCount() {
        return stuCount;
    }

    public static void setStuCount(int stuCount) {
        Student.stuCount = stuCount;
    }
    public void eat(){

    }
    public Student() {
        Student.stuCount++;
    }
    public static void m(){
        System.out.println(123);
    }
}
