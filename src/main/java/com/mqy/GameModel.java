package com.mqy;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TF014268
 * @description 门面类
 * @since 2021/8/3 0003 19:36
 */
public class GameModel {

    //创建一个坦克
    Tank tank = new Tank(300,500, Dir.DOWN, Group.GOOD,this);

    List<Tank> tankList = new ArrayList<Tank>();

    //子弹集合
    List<Bullet> bulletList = new ArrayList<Bullet>();

    //爆炸的集合
    List<Explode> explodeList = new ArrayList<Explode>();

    public GameModel(){
        //读取配置
        int tanksCount = Integer.valueOf(PropertyMgr.get("initTankCount").toString());
        int x = Integer.valueOf(PropertyMgr.get("badTankStartX").toString());
        int y = Integer.valueOf(PropertyMgr.get("badTankStartY").toString());

        for(int i=0;i<tanksCount;i++){
            tankList.add(new Tank(x + i*50,y +i*50, Dir.DOWN, Group.BAD,this));
        }
    }

    //绘画方法
    public void paint(Graphics graphics){
        Color color = graphics.getColor();
        graphics.setColor(Color.WHITE);
        graphics.drawString("子弹的数量：" + bulletList.size(),10,60);
        graphics.drawString("敌人的数量：" + tankList.size(),10,80);
        graphics.drawString("爆炸的数量：" + explodeList.size(),10,100);
        graphics.setColor(color);

        //把画笔交给坦克类自己去画
        tank.paint(graphics);

        for(int i=0;i<tankList.size();i++){
            tankList.get(i).paint(graphics);
        }

        for(int i=0;i<bulletList.size();i++){
            //把画笔交给子弹类自己去画
            bulletList.get(i).paint(graphics);
        }

        for(int i=0;i<explodeList.size();i++){
            //画爆炸的图
            explodeList.get(i).paint(graphics);
        }

        //子弹和坦克碰撞时，坦克消失
        for(int i=0;i<bulletList.size();i++){
            for(int j=0;j<tankList.size();j++){
                bulletList.get(i).toHit(tankList.get(j));
            }
        }

    }
}
