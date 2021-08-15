package com.mqy;

import com.mqy.cor.Collider;
import com.mqy.decorator.TailTankDecorator;
import com.mqy.flyweight.BulletPool;

import java.awt.*;

/**
 * @author TF014268
 * @description 子弹类
 * @since 2021/7/27 0027 20:32
 */
public class Bullet extends GameGoods{
    //设置子弹的速度
    private static final int SPEED = 5;
    //设置子弹的大小--获取图片大小
    public static int WIDTH = ResourceMgr.bulletU.getWidth();
    public static int HEIGHT = ResourceMgr.bulletU.getHeight();

    //分组  我方  敌方
    private Group group;

//    //子弹的位置
//    private int x,y;
//    //子弹的方向
//    private Dir dir;
    //子弹的存活状态
    private boolean live = true;

    //撞击检测的位置
    public Rectangle rect = new Rectangle();

    public Bullet(){
        //默认子弹是死亡的
        live=false;
    }

    public Bullet(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;

        //初始化碰撞检测的rect
        rect.x = x;
        rect.y = y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
        //把游戏物品添加到游戏模板中
        GameModel.getInstance().add(this);
    }

    public Bullet buildBullet(int x, int y, Dir dir, Group group){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;

        //初始化碰撞检测的rect
        rect.x = x;
        rect.y = y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
        //把游戏物品添加到游戏模板中
        GameModel.getInstance().add(this);

        return this;
    }

    //用画笔画子弹
    @Override
    public void paint(Graphics graphics){
        switch (dir){
            case LEFT:
                graphics.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case RIGHT:
                graphics.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            case DOWN:
                graphics.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
            case UP:
                graphics.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
            default:
                graphics.drawImage(ResourceMgr.bulletU,x,y,null);
        }

        move();
    }

    @Override
    public Dir getDir() {
        return dir;
    }

    //移动的方法
    private void move() {
        //子弹的存活状态为消失，则删除
        if(!this.live){
            GameModel.getInstance().remove(this);
            return;
        }

        switch (dir){
            case LEFT :
                x -= SPEED;
                break;
            case RIGHT :
                x += SPEED;
                break;
            case UP :
                y -= SPEED;
                break;
            case DOWN :
                y += SPEED;
                break;
        }

        //移动后，改变碰撞检测的位置
        rect.x = this.x;
        rect.y = this.y;

        //如果子弹超出游戏界面，把存活状态设为false
        if(x<0 || y<0 || x> TankFrame.getGameWidth() || y> TankFrame.getGameHeight()){
            this.live = false;
        }
    }

    //子弹消失
    public void die() {
        this.live = false;
        //在子弹池里删除
        BulletPool.getInstance().remove(this);
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }


    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }
}
