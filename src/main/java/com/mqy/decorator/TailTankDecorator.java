package com.mqy.decorator;

import com.mqy.ResourceMgr;
import com.mqy.Tank;

import java.awt.*;

/**
 * @author TF014268
 * @description 带尾巴的坦克
 * @since 2021/8/5 0005 11:02
 */
public class TailTankDecorator implements TankDecorator{
    private Tank tank;

    public TailTankDecorator(Tank tank){
        this.tank = tank;
    }

    @Override
    public void paint(Graphics graphics) {
        int x = 0;
        int y = 0;
        int imageW = ResourceMgr.fiveImage.getWidth();
        int imageH = ResourceMgr.fiveImage.getHeight();

        switch (tank.getDir()){
            case UP:
                x = tank.getX()+Tank.WIDTH/2-imageW/2;
                y = tank.getY()+Tank.HEIGHT;
                break;
            case LEFT:
                x = tank.getX()+Tank.WIDTH;
                y = tank.getY()+Tank.HEIGHT/2-imageH/2;
                break;
            case RIGHT:
                x = tank.getX()-imageW;
                y = tank.getY()+Tank.HEIGHT/2-imageH/2;
                break;
            case DOWN:
                x = tank.getX() + Tank.WIDTH/2 - imageW/2;
                y = tank.getY() - imageH;
                break;
        }
        graphics.drawImage(ResourceMgr.fiveImage,x,y,null);
    }
}
