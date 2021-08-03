package com.mqy.abstractFactory.rectType;

import com.mqy.abstractFactory.base.BaseBullet;
import com.mqy.abstractFactory.base.BaseExplode;
import com.mqy.abstractFactory.base.BaseTank;
import com.mqy.abstractFactory.base.GameFactory;
import com.mqy.emuns.Dir;
import com.mqy.emuns.Group;
import com.mqy.abstractFactory.defaultType.Tank;
import com.mqy.service.TankFrame;

/**
 * @author TF014268
 * @description 坦克、子弹、爆炸全部为方形的工厂
 * @since 2021/8/3 0003 10:54
 */
public class RectFactory implements GameFactory {
    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new RectTank(x,y,dir,group,tankFrame);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new RectBullet(x, y, dir, group, tankFrame);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tankFrame) {
        return new RectExplode(x,y,tankFrame);
    }
}
