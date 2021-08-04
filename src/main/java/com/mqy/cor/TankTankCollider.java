package com.mqy.cor;

import com.mqy.Bullet;
import com.mqy.Explode;
import com.mqy.GameGoods;
import com.mqy.Tank;

/**
 * @author TF014268
 * @description 子弹、坦克撞击器
 * @since 2021/8/4 0004 11:23
 */
public class TankTankCollider implements Collider{
    @Override
    public boolean collide(GameGoods g1, GameGoods g2) {
        if(g1 instanceof Tank && g2 instanceof Tank){
            Tank tank1 = (Tank)g1;
            Tank tank2 = (Tank)g2;
            //撞击方法
            return toHit(tank1,tank2);
        }
        return false;
    }


    //子弹撞击坦克  撞击返回true
    private boolean toHit(Tank tank1,Tank tank2) {
        if(tank1.rect.intersects(tank2.rect)){
            tank1.stop();
            tank2.stop();
        }

        return false;
    }
}
