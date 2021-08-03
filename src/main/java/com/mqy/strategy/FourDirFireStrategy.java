package com.mqy.strategy;

import com.mqy.abstractFactory.base.BaseTank;
import com.mqy.abstractFactory.defaultType.Bullet;
import com.mqy.abstractFactory.rectType.RectBullet;
import com.mqy.abstractFactory.rectType.RectTank;
import com.mqy.emuns.Dir;
import com.mqy.abstractFactory.defaultType.Tank;

/**
 * @author TF014268
 * @description 四个方向都开火的策略
 * @since 2021/8/2 0002 15:39
 */
public class FourDirFireStrategy implements FireStrategy {
    @Override
    public void fire(BaseTank baseTank) {
        if(baseTank instanceof Tank){
            Tank tank = (Tank) baseTank;
            //计算子弹的位置
            int bX = tank.getX() + (Tank.WIDTH/2) - Bullet.WIDTH/2;
            int bY = tank.getY() + (Tank.HEIGHT/2) - Bullet.HEIGHT/2;


            //坦克四个方向发射子弹
            Dir[] dirs = Dir.values();
            for(Dir dir : dirs){
                new RectBullet(bX,bY,dir,tank.getGroup(),tank.getTankFrame());
            }
        }else{
            RectTank tank = (RectTank) baseTank;
            //计算子弹的位置
            int bX = tank.getX() + (Tank.WIDTH/2) - Bullet.WIDTH/2;
            int bY = tank.getY() + (Tank.HEIGHT/2) - Bullet.HEIGHT/2;


            //坦克四个方向发射子弹
            Dir[] dirs = Dir.values();
            for(Dir dir : dirs){
                new RectBullet(bX,bY,dir,tank.getGroup(),tank.getTankFrame());
            }
        }


    }
}
