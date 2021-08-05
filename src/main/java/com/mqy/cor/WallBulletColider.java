package com.mqy.cor;

import com.mqy.*;

/**
 * @author TF014268
 * @description 子弹和墙体相撞处理器
 * @since 2021/8/4 0004 17:10
 */
public class WallBulletColider implements Collider{
    @Override
    public boolean collide(GameGoods g1, GameGoods g2) {
        if(g1 instanceof Wall && g2 instanceof Bullet){
            Wall wall = (Wall)g1;
            Bullet bullet = (Bullet) g2;
            return toHit(bullet, wall);
        }else if(g1 instanceof Bullet && g2 instanceof Wall){
            return collide(g2, g1);
        }else{
            return false;
        }
    }

    //子弹撞击墙体  撞击返回true
    private boolean toHit(Bullet bullet, Wall wall) {
                /*如果坦克已经死了，就不再检测碰撞。
        多颗子弹碰撞同一个坦克会出现多个爆炸图片的bug*/
        if(bullet.isLive()==false){
            return true;
        }

        //子弹的位置和墙体的位置比较
        if(bullet.rect.intersects(wall.rect)){
            //撞击了，子弹消失，墙体不变
            bullet.die();

            //在子弹的位置显示爆炸
            bullet.getGameModel().add(new Explode(wall.getX(),wall.getY(),bullet.getGameModel()));
            return true;
        }
        return false;
    }
}
