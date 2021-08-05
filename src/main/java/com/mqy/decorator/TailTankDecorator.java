package com.mqy.decorator;

import com.mqy.GameGoods;
import com.mqy.ResourceMgr;
import com.mqy.Tank;
import java.awt.*;

/**
 * @author TF014268
 * @description 带尾巴的坦克
 * @since 2021/8/5 0005 11:02
 */
public class TailTankDecorator implements TankDecorator{
    private GameGoods g;

    public TailTankDecorator(GameGoods g){
        this.g = g;
    }

    @Override
    public void paint(Graphics graphics) {
        int x = 0;
        int y = 0;
        int imageW = ResourceMgr.fiveImage.getWidth();
        int imageH = ResourceMgr.fiveImage.getHeight();

        int gx = g.getX();
        int gy = g.getY();

        switch (g.getDir()){
            case UP:
                x = gx+Tank.WIDTH/2-imageW/2;
                y = gy+Tank.HEIGHT;
                break;
            case LEFT:
                x = gx+Tank.WIDTH;
                y = gy+Tank.HEIGHT/2-imageH/2;
                break;
            case RIGHT:
                x = gx-imageW;
                y = gy+Tank.HEIGHT/2-imageH/2;
                break;
            case DOWN:
                x = gx + Tank.WIDTH/2 - imageW/2;
                y = gy - imageH;
                break;
        }
        graphics.drawImage(ResourceMgr.fiveImage,x,y,null);
    }
}
