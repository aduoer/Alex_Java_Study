package qf.task.week03.day01.tracfic;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week03.day01.tracfic
 * @company lpc
 * date 2023/7/31 10:12
 */
public abstract class TracficTool {
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public TracficTool() {
    }

    public TracficTool(String brand) {
        this.brand = brand;
    }
    public abstract void run();
}
