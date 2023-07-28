package qf.task.week02.day05.animal;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week02.day05.animal
 * @company lpc
 * date 2023/7/28 15:20
 */
public class Master {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Master() {
    }

    public Master(String name) {
        this.name = name;
    }

    public void feed(Animal animal){
        System.out.println("feed");
        animal.eat();
    }
    public Animal adpot(int type){
        if(type == 1){
            return new Dog("泰迪",1,"g","heis");
        }
        if(type == 2){
            return new Cat("布偶",1,"g","heis");
        }
        return null;
    }
}
