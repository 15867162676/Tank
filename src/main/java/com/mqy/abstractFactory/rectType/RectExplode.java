package com.mqy.abstractFactory.rectType;

import com.mqy.abstractFactory.base.BaseExplode;
import com.mqy.service.TankFrame;
import com.mqy.util.ResourceMgr;

import java.awt.*;

/**
 * @author TF014268
 * @description 方形的爆炸
 * @since 2021/8/3 0003 11:15
 */
public class RectExplode extends BaseExplode {
    //获取图片大小
    public static int WIDTH = ResourceMgr.rectEx[0].getWidth();
    public static int HEIGHT = ResourceMgr.rectEx[0].getHeight();

    //位置
    private int x,y;

    //播放到第几张图片了
    private int page = 0;

    //引用游戏界面
    private TankFrame tankFrame = null;

    public RectExplode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
    }

    //用画笔画
    @Override
    public void paint(Graphics graphics){
        graphics.drawImage(ResourceMgr.rectEx[page],this.x,this.y,null);
        this.page++;
        if(page >= ResourceMgr.rectEx.length){
            //爆炸图片放完了，删除
            this.tankFrame.explodeList.remove(this);
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
