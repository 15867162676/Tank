package com.mqy.flyweight;

import com.mqy.Bullet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TF014268
 * @description 享元模式--子弹池
 * @since 2021/8/6 0006 11:09
 */
public class BulletPool {
    private final static BulletPool INSTANCE = new BulletPool();

    public static BulletPool getInstance(){
        return INSTANCE;
    }

    private BulletPool(){}

    private final static List<Bullet> bulletList = new ArrayList();

    //初始化子弹池
    static{
        for(int i=0;i<10;i++){
            bulletList.add(new Bullet());
        }
    }

    public void remove(Bullet bullet){
        if(bulletList.size() > 10){
            bulletList.remove(bullet);
        }else{
            bullet.setLive(false);
        }

    }

    //获取子弹
    public Bullet getBullet(){
//        ClassLoader
        for(Bullet bullet : bulletList){
            if(bullet.isLive()){
                continue;
            }
            System.out.println("拿到子弹了");
            //如果子弹是不存活的，设置为存活，就返回
            bullet.setLive(true);
            return bullet;
        }
        Bullet bullet = new Bullet();
        bullet.setLive(true);
        bulletList.add(bullet);
        //输出子弹池中的子弹数量
        System.out.println(bulletList.size());
        return bullet;
    }
}
