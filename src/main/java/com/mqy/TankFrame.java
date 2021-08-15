package com.mqy;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author TF014268
 * @description 坦克大战窗口
 * @since 2021/7/27 0027 14:49
 */
public class TankFrame extends Frame {
    //设置游戏界面的大小
    private static final int GAME_WIDTH = 1080;
    private static final int GAME_HEIGHT = 960;

    private GameModel gameModel = GameModel.getInstance();

    public TankFrame(){
        //设置窗口大小
        this.setSize(GAME_WIDTH,GAME_HEIGHT);
        //设置窗口不能拖拽改变大小
        this.setResizable(false);
        //设置窗口标题
        this.setTitle("坦克游戏");
        //显示一个小窗口
        this.setVisible(true);

        //设置键盘监听器
        this.addKeyListener(new MyKeyListener());

        //设置窗口可关闭
        //监听  点击  关闭小叉子事件
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //系统退出
                System.exit(0);
            }
        });
    }

    // 在内存中定义一张图片
    Image offScreenImage = null;

    /*repaint()方法会先调用update方法，
    update方法会先把坦克等绘画到内存图片中，
    然后再把内存的内容复制到显存
    */
    @Override
    public void update(Graphics g) {
        if(null==offScreenImage){
            //图片大小和游戏界面大小一致
            offScreenImage = this.createImage(GAME_WIDTH,GAME_WIDTH);
        }
        //拿到  图片  上的画笔
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color color = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0,0,GAME_WIDTH,GAME_WIDTH);
        gOffScreen.setColor(color);

        /*把图片上的画笔交个paint方法，
        那么绘制坦克等内容直接绘制到了内存的图片上*/
        paint(gOffScreen);
        //系统一次性把图片上的内容画到游戏界面上
        g.drawImage(offScreenImage,0,0,null);

    }


    //此方法会被系统自动调用
    //需要重新绘制窗口的时候调用，比如窗口切换回来、窗口改变大小
    @Override
    public void paint(Graphics graphics){
        gameModel.paint(graphics);
    }

    //按键监听器内部类
    class MyKeyListener extends KeyAdapter {

        boolean bL = false;  //向左键
        boolean bR = false;  //向右键
        boolean bU = false;  //向上键
        boolean bD = false;  //向下键

        //某个按键按下去的事件
        @Override
        public void keyPressed(KeyEvent e) {
            //按下的具体是哪个键
            int keyCode = e.getKeyCode();
            switch(keyCode){
                case KeyEvent.VK_LEFT:  //按下的是向左的键
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                case KeyEvent.VK_CONTROL:
                    gameModel.tank.fire();  //点击Ctrl键 调用开火方法
                    break;
                case KeyEvent.VK_S:
                    //点击S键存档
                    gameModel.save();
                    break;
                case KeyEvent.VK_R:
                    //点击R键读取
                    gameModel.read();
                    break;
                default:
            }
            //设置坦克的方向
            setMainTankDir();
        }

        //设置坦克的方向
        private void setMainTankDir(){
            //如果四个方向都没点击，坦克就是静止的
            if(!bL && !bR && !bU && !bD){
                gameModel.tank.setMoving(false);
                return;
            }

            gameModel.tank.setMoving(true);
            if(bL){
                gameModel.tank.setDir(Dir.LEFT);
            }
            if(bR){
                gameModel.tank.setDir(Dir.RIGHT);
            }
            if(bU){
                gameModel.tank.setDir(Dir.UP);
            }
            if(bD){
                gameModel.tank.setDir(Dir.DOWN);
            }
        }

        //某个按键弹起来的事件
        @Override
        public void keyReleased(KeyEvent e) {
            //按下的具体是哪个键
            int keyCode = e.getKeyCode();
            switch(keyCode){
                case KeyEvent.VK_LEFT:  //按下的是向左的键
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
            }
            //设置坦克的方向
            setMainTankDir();
        }

    }

    public static int getGameWidth() {
        return GAME_WIDTH;
    }

    public static int getGameHeight() {
        return GAME_HEIGHT;
    }
}
