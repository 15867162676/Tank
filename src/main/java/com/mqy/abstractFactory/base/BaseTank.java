package com.mqy.abstractFactory.base;

import com.mqy.emuns.Dir;
import com.mqy.emuns.Group;

import java.awt.*;

/**
 * @author TF014268
 * @description 坦克抽象接口
 * @since 2021/8/3 0003 10:43
 */
public abstract class BaseTank {

    //分组  我方  敌方
    public Group group = Group.BAD;

    public abstract void paint(Graphics graphics);

    public abstract Group getGroup();

    public abstract void setMoving(boolean b);

    public abstract void setDir(Dir left);

    public abstract void fire();
}
