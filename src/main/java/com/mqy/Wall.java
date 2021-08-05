package com.mqy;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TF014268
 * @description 墙
 * @since 2021/8/4 0004 16:43
 */
public class Wall extends GameGoods{
//    //设置坦克的位置
//    private int x;
//    private int y;

    //获取墙体图片大小
    public static int WIDTH = ResourceMgr.wallImage.getWidth();
    public static int HEIGHT = ResourceMgr.wallImage.getHeight();

    //撞击检测的位置
    public Rectangle rect = new Rectangle();

    public Wall(int x, int y){
        this.x = x;
        this.y = y;

        rect.x = x;
        rect.y = y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        //把游戏物品添加到游戏模板中
        GameModel.getInstance().add(this);
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawImage(ResourceMgr.wallImage,x,y,null);
    }

    @Override
    public Dir getDir() {
        return dir;
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
}
