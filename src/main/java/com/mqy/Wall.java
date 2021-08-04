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
    //设置坦克的位置
    private int x;
    private int y;

    //获取墙体图片大小
    public static int WIDTH = ResourceMgr.wallImage.getWidth();
    public static int HEIGHT = ResourceMgr.wallImage.getHeight();

    List<GameGoods> gameGoodsList = new ArrayList<>();

    //持有一个游戏界面类的引用
    private GameModel gameModel = null;

    //撞击检测的位置
    public Rectangle rect = new Rectangle();

    public Wall(int x, int y, GameModel gameModel){
        this.x = x;
        this.y = y;
        this.gameModel = gameModel;

        rect.x = x;
        rect.y = y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
    }

    @Override
    public void paint(Graphics graphics) {
        graphics.drawImage(ResourceMgr.wallImage,x,y,null);
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
