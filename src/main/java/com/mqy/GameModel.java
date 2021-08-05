package com.mqy;

import com.mqy.cor.ColliderChain;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TF014268
 * @description 门面类
 * @since 2021/8/3 0003 19:36
 */
public class GameModel {

    private static final GameModel INSTANCE = new GameModel();

    static{
        //调用初始化方法
        INSTANCE.init();
    }

    //创建一个坦克
    Tank tank;

    private List<GameGoods> goodsList = new ArrayList<>();

    //撞击责任链
    ColliderChain colliderChain = new ColliderChain();

    //单例模式
    public static GameModel getInstance(){
        return INSTANCE;
    }

    private GameModel(){
    }

    //初始化方法
    private void init(){
        tank = new Tank(300,500, Dir.DOWN, Group.GOOD);
        //读取配置
        int tanksCount = Integer.valueOf(PropertyMgr.get("initTankCount").toString());
        int x = Integer.valueOf(PropertyMgr.get("badTankStartX").toString());
        int y = Integer.valueOf(PropertyMgr.get("badTankStartY").toString());

        for(int i=0;i<tanksCount;i++){
            new Tank(x + i*100,y +i*100, Dir.DOWN, Group.BAD);
        }

        //初始化墙体
        for(int i=0;i<60;i++){
            //横着的x轴最上面的
            new Wall(20*i,20);
            //竖着的y轴左面的
            new Wall(0,20*i);
            //竖着的y轴右面的
            new Wall(TankFrame.getGameWidth()-Wall.WIDTH,20*i);
            //横着的x轴下面的
            new Wall(20*i,TankFrame.getGameHeight()-Wall.HEIGHT);
        }

        for(int i=0;i<10;i++){
            new Wall(200+ 20*(i+1),300);
            new Wall(200+ 20*(i+1),320);

            new Wall(500,300+ 20*(i+1));
            new Wall(520,300+ 20*(i+1));
            new Wall(540,300+ 20*(i+1));
        }
    }

    //添加物品
    public void add(GameGoods gameGoods){
        goodsList.add(gameGoods);
    }

    //删除物品
    public void remove(GameGoods gameGoods){
        goodsList.remove(gameGoods);
    }

    //绘画方法
    public void paint(Graphics graphics){
        Color color = graphics.getColor();
        graphics.setColor(Color.WHITE);
//        graphics.drawString("子弹的数量：" + bulletList.size(),10,60);
//        graphics.drawString("敌人的数量：" + tankList.size(),10,80);
//        graphics.drawString("爆炸的数量：" + explodeList.size(),10,100);
        graphics.setColor(color);

        //把画笔交给坦克类自己去画
        tank.paint(graphics);

        //画出所有的物品（不同物品调用自己的实现）
        for(int i=0;i<goodsList.size();i++){
            goodsList.get(i).paint(graphics);
        }

        //子弹和坦克碰撞时，坦克消失
        for(int i=0;i<goodsList.size();i++){
            for(int j=i+1;j<goodsList.size();j++){
                GameGoods g1 = goodsList.get(i);
                GameGoods g2 = goodsList.get(j);
                //检测撞击
                colliderChain.collide(g1,g2);
            }
        }

    }
}
