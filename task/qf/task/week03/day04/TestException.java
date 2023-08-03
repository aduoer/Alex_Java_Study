package qf.task.week03.day04;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day04
 * @company lpc
 * date 2023/8/3 16:29
 */
public class TestException {

    public static void main(String[] args) {
//        System.out.println(get());
        try {
            System.out.println(setAge(120));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
// 在setAge(int age)中对年龄进行判断，如果年龄介于1到100直接赋值，否则抛出异常。
//
//在测试类中创建对象并调用setAge(int age)方法，使用try...catch捕获并处理异常。
    private static boolean setAge(int age) throws Exception {
        if(age < 100 && age > 1){
            return true;
        }else {
            throw new Exception();
        }
    }
    private static int get(){
        int n = 10;
        try {
            return n++;
        }catch (Exception e){
            return n++;
        }finally {
            n++;
        }
    }
}
