package qf.task.week02.day05.animal;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week02.day05
 * @company lpc
 * date 2023/7/28 9:36
 */
public class AnimalTest {
    public static void main(String[] args) {

        Master master = new Master();
        master.setName("赵云");
        Animal a = master.adpot(0);
        if(a != null){
            System.out.println("领养" + a.breed + "成功");
        }else {
            System.out.println("不喜欢你");
        }
    }
}
