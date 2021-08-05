package com.mqy;

import com.mqy.ResourceMgr;
import com.mqy.TankFrame;

import java.awt.*;

/**
 * @author TF014268
 * @description 爆炸类
 * @since 2021/7/27 0027 20:32
 */
public class Explode extends GameGoods{

    //获取图片大小
    public static int WIDTH = ResourceMgr.bufferedImages[0].getWidth();
    public static int HEIGHT = ResourceMgr.bufferedImages[0].getHeight();

    //位置
    private int x,y;

    //播放到第几张图片了
    private int page = 0;

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
        //把游戏物品添加到游戏模板中
        GameModel.getInstance().add(this);
    }

    //用画笔画
    @Override
    public void paint(Graphics graphics){
        graphics.drawImage(ResourceMgr.bufferedImages[page],this.x,this.y,null);
        this.page++;
        if(page >= ResourceMgr.bufferedImages.length){
            //爆炸图片放完了，删除
            GameModel.getInstance().remove(this);
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
