package RuanKao.rk201905;

/**
 * @author TF014268
 * @description 长痕迹
 * @since 2021/10/13 0013 18:36
 */
public class LongWheelBrake implements BrakeBehavior{
    @Override
    public void stop() {
        System.out.println("长轮胎刹车痕迹");
    }
}
