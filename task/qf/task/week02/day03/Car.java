package qf.task.week02.day03;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week02.day03
 * @company lpc
 * date 2023/7/26 17:10
 */
public class Car {
    String color;
    String brand;
    String price;

    public Car() {
        this("黑色","奔驰","30w");
    }
    public Car(String color) {
        this.color = color;
    }
    public Car(String color, String brand) {
        this.color = color;
        this.brand = brand;
    }
    public Car(String color, String brand, String price) {
        this.color = color;
        this.brand = brand;
        this.price = price;
    }

    public void dirve(){
        System.out.println("启动!");
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
