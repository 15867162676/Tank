package com.mqy;

import com.mqy.cor.Collider;

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

    //下一个处理器引用
    private Collider toHitHandler;

    //分组  我方  敌方
    private Group group;

    //子弹的位置
    private int x,y;
    //子弹的方向
    private Dir dir;
    //子弹的存活状态
    private boolean live = true;

    //撞击检测的位置
    public Rectangle rect = new Rectangle();

    //引用游戏界面
    private GameModel gameModel = null;

    public Bullet(int x, int y, Dir dir, Group group, GameModel gameModel) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.gameModel = gameModel;

        //初始化碰撞检测的rect
        rect.x = x;
        rect.y = y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
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

    //移动的方法
    private void move() {
        //子弹的存活状态为消失，则删除
        if(!this.live){
            gameModel.remove(this);
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
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }


    public GameModel getGameModel() {
        return gameModel;
    }

    public void setGameModel(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
