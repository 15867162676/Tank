package com.mqy;

import java.awt.*;

/**
 * @author TF014268
 * @description 游戏物品抽象类
 * @since 2021/8/4 0004 10:21
 */
public abstract class GameGoods {
    protected int x,y;
    protected Dir dir;

    //画物品的抽象方法
    public abstract void paint(Graphics graphics);

    public abstract Dir getDir();
    public abstract int getX();
    public abstract int getY();
}
