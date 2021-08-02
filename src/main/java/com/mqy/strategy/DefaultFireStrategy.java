package com.mqy.strategy;

import com.mqy.service.Bullet;
import com.mqy.service.Tank;

/**
 * @author TF014268
 * @description 默认开火策略
 * @since 2021/8/2 0002 15:33
 */
public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank tank) {
        //计算子弹的位置
        int bX = tank.getX() + (Tank.WIDTH/2) - Bullet.WIDTH/2;
        int bY = tank.getY() + (Tank.HEIGHT/2) - Bullet.HEIGHT/2;
        //子弹的位置和方向和坦克一样
        new Bullet(bX,bY,tank.getDir(),tank.getGroup(),tank.getTankFrame());

//        if(tank.getGroup() == Group.GOOD){
//            new Thread(() -> new Audio("addio/war1.wav").loop()).start();
//        }
    }
}
