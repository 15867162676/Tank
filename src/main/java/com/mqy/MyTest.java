package com.mqy;

import com.mqy.PropertyMgr;

/**
 * @author TF014268
 * @description test
 * @since 2021/7/26 0026 16:36
 */
public class MyTest {

    public static void main(String[] args) throws Exception {
        TankFrame tankFrame = new TankFrame();


        //爆炸的声音
//        new Thread(() -> new Audio("addio/war1.wav").loop()).start();

        while (true){
            //窗口重绘的的间隔时间
            Thread.sleep(50);
            //调用窗口重绘接口  会自动调用paint(Graphics graphics)方法
            tankFrame.repaint();
        }
    }
}
