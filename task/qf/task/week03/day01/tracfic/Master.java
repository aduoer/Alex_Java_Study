package qf.task.week03.day01.tracfic;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day01.tracfic
 * @company lpc
 * date 2023/7/31 10:14
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

    public void goHome(TracficTool trac){
        trac.run();
    }
}
