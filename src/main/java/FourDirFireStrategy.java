/**
 * @author TF014268
 * @description 四个方向都开火的策略
 * @since 2021/8/2 0002 15:39
 */
public class FourDirFireStrategy implements FireStrategy{
    @Override
    public void fire(Tank tank) {
        //计算子弹的位置
        int bX = tank.getX() + (Tank.WIDTH/2) - Bullet.WIDTH/2;
        int bY = tank.getY() + (Tank.HEIGHT/2) - Bullet.HEIGHT/2;

        //坦克四个方向发射子弹
        Dir[] dirs = Dir.values();
        for(Dir dir : dirs){
            new Bullet(bX,bY,dir,tank.getGroup(),tank.getTankFrame());
        }
    }
}
