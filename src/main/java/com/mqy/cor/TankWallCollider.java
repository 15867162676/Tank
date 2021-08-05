package com.mqy.cor;

import com.mqy.GameGoods;
import com.mqy.Tank;
import com.mqy.Wall;

/**
 * @author TF014268
 * @description 坦克和墙相撞的类
 * @since 2021/8/5 0005 9:04
 */
public class TankWallCollider implements Collider{
    @Override
    public boolean collide(GameGoods g1, GameGoods g2) {
        if(g1 instanceof Tank && g2 instanceof Wall){
            Tank tank = (Tank) g1;
            Wall wall = (Wall) g2;
            toHit(tank,wall);
        }else if(g1 instanceof Wall && g2 instanceof Tank){
            collide(g2,g1);
        }else{

        }
        return false;
    }

    //坦克撞墙
    private boolean toHit(Tank tank, Wall wall) {
        if(tank.rect.intersects(wall.rect)){
            tank.back();
            return true;
        }
        return false;
    }
}
