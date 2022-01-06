package RuanKao.rk201905;

/**
 * @author TF014268
 * @description 短轮胎痕迹
 * @since 2021/10/13 0013 18:37
 */
public class ShortWheelBrake implements BrakeBehavior{
    @Override
    public void stop() {
        System.out.println("短的刹车痕迹");
    }
}
