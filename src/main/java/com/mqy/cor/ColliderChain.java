package com.mqy.cor;

import com.mqy.GameGoods;

import java.util.LinkedList;
import java.util.List;

/**
 * @author TF014268
 * @description 撞击责任链
 * @since 2021/8/4 0004 16:17
 */
//责任链也实现了Collider   那么就可以直接合并多个责任链了
public class ColliderChain implements Collider{
    private List<Collider> colliderList = new LinkedList<>();

    public ColliderChain(){
        add(new TankTankCollider());
        add(new BulletTankCollider());
        add(new WallBulletColider());
    }

    //添加方法
    public void add(Collider collider){
        colliderList.add(collider);
    }

    @Override
    public boolean collide(GameGoods g1, GameGoods g2) {
        for(int i=0;i<colliderList.size();i++){
            boolean collide = colliderList.get(i).collide(g1, g2);
            if(collide){
                return true;
            }
        }
        return false;
    }
}
