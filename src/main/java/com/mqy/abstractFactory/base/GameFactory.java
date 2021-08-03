package com.mqy.abstractFactory.base;

import com.mqy.emuns.Dir;
import com.mqy.emuns.Group;
import com.mqy.service.TankFrame;

/**
 * @author TF014268
 * @description 抽象工厂接口
 * @since 2021/8/3 0003 10:45
 */
public interface GameFactory {
    //创建坦克
    BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tankFrame);
    //创建子弹
    BaseBullet createBullet(int x,int y, Dir dir, Group group,TankFrame tankFrame);
    //创建爆炸
    BaseExplode createExplode(int x,int y,TankFrame tankFrame);
}
