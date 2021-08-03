package com.mqy.abstractFactory.base;

import java.awt.*;

/**
 * @author TF014268
 * @description 抽象子弹接口
 * @since 2021/8/3 0003 10:47
 */
public abstract class BaseBullet {
    public abstract void paint(Graphics graphics);

    public abstract void toHit(BaseTank baseTank);
}
