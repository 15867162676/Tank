package RuanKao.rk201905;

/**
 * @author TF014268
 * @description 车
 * @since 2021/10/13 0013 18:38
 */
abstract class Car {
    protected BrakeBehavior wheel;

    public void brake(){
        wheel.stop();
    }
}
