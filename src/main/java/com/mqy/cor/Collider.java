package com.mqy.cor;

import com.mqy.GameGoods;

/**
 * @author TF014268
 * @description 撞击比较器
 * @since 2021/8/4 0004 10:45
 */
public interface Collider {

    //物体两两比较
    public void collide(GameGoods g1, GameGoods g2);

}
