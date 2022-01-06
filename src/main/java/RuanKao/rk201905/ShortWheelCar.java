package RuanKao.rk201905;

/**
 * @author TF014268
 * @description 短轮胎车
 * @since 2021/10/13 0013 18:39
 */
public class ShortWheelCar extends Car{
    public ShortWheelCar(BrakeBehavior behavior) {
//        behavior.stop();
        super.wheel = behavior;
    }

}
