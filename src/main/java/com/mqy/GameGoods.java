package com.mqy;

import java.awt.*;

/**
 * @author TF014268
 * @description 游戏物品抽象类
 * @since 2021/8/4 0004 10:21
 */
public abstract class GameGoods {
    public int x,y;

    //画物品的抽象方法
    public abstract void paint(Graphics graphics);
}
