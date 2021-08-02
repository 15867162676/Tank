package com.mqy.strategy;

import com.mqy.service.Tank;

/**
 * @author TF014268
 * @description 开火的策略接口
 * @since 2021/8/2 0002 15:14
 */
public interface FireStrategy {
    void fire(Tank tank);
}
