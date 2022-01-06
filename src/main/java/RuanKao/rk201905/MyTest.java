package RuanKao.rk201905;

/**
 * @author TF014268
 * @description test
 * @since 2021/10/13 0013 18:40
 */
public class MyTest {
    public static void main(String[] args) {
        BrakeBehavior brakeBehavior = new ShortWheelBrake();
        ShortWheelCar car = new ShortWheelCar(brakeBehavior);
        car.brake();
    }
}
