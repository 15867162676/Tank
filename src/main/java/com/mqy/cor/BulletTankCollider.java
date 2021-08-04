package com.mqy.cor;

import com.mqy.*;

/**
 * @author TF014268
 * @description 子弹、坦克撞击器
 * @since 2021/8/4 0004 11:23
 */
public class BulletTankCollider implements Collider{
    @Override
    public boolean collide(GameGoods g1, GameGoods g2) {
        if(g1 instanceof Tank && g2 instanceof Bullet){
            Tank tank = (Tank)g1;
            Bullet bullet = (Bullet)g2;
            //撞击方法
            return toHit(bullet,tank);
        }else if(g1 instanceof  Bullet && g2 instanceof Tank){
            return collide(g2, g1);
        }else{
            return false;
        }
    }


    //子弹撞击坦克  撞击返回true
    private boolean toHit(Bullet bullet,Tank tank) {
        //如果是自己方的，不会打死
        if(bullet.getGroup()==tank.getGroup()){
            return false;
        }
        /*如果坦克已经死了，就不再检测碰撞。
        多颗子弹碰撞同一个坦克会出现多个爆炸图片的bug*/
        if(tank.isLive()==false){
            return true;
        }

        //子弹的位置和坦克的位置比较
        if(bullet.rect.intersects(tank.rect)){
            //撞击了，子弹消失，坦克消失
            tank.die();
            bullet.die();

            //计算爆炸的位置--在坦克的中心位置上爆炸
            //坦克的位置坐标 + 坦克位置的一半 - 爆炸图片的一半
            int eX = tank.getX() + (Tank.WIDTH/2) - Explode.WIDTH/2;
            int eY = tank.getY() + (Tank.HEIGHT/2) - Explode.HEIGHT/2;
            //显示爆炸
            bullet.getGameModel().add(new Explode(eX,eY,bullet.getGameModel()));
            return true;
        }
        return false;
    }
}
