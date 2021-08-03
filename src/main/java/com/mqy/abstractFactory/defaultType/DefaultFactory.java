package com.mqy.abstractFactory.defaultType;

import com.mqy.abstractFactory.base.BaseBullet;
import com.mqy.abstractFactory.base.BaseExplode;
import com.mqy.abstractFactory.base.BaseTank;
import com.mqy.abstractFactory.base.GameFactory;
import com.mqy.emuns.Dir;
import com.mqy.emuns.Group;
import com.mqy.service.TankFrame;

/**
 * @author TF014268
 * @description 默认的工厂
 * @since 2021/8/3 0003 11:11
 */
public class DefaultFactory implements GameFactory {
    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new Tank(x, y, dir, group, tankFrame);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new Bullet(x, y, dir, group, tankFrame);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tankFrame) {
        return new Explode(x, y, tankFrame);
    }
}
