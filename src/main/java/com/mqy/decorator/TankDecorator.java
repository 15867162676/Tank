package com.mqy.decorator;

import java.awt.*;
import java.io.Serializable;

/**
 * @author TF014268
 * @description 坦克装饰接口
 * @since 2021/8/5 0005 11:00
 */
public interface TankDecorator extends Serializable {
    
    void paint(Graphics graphics);
}
