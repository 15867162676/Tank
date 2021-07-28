import java.awt.*;

/**
 * @author TF014268
 * @description 坦克类
 * @since 2021/7/27 0027 19:00
 */
public class Tank {
    //设置坦克的尺寸
    private int x;
    private int y;

    //设置坦克的大小
    private static int WIDTH = 50;
    private static int HEIGHT = 50;
    //持有一个游戏界面类的引用
    private TankFrame tankFrame = null;

    //设置坦克的初始方向
    private Dir dir;
    //坦克每次移动的距离
    private static final int SPEED = 5;
    //坦克是否是移动的
    private boolean moving;

    public Tank(int x, int y, Dir dir,TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    //使用画笔绘画坦克
    public void paint(Graphics graphics){
        //获取画笔原来的颜色
        Color color = graphics.getColor();
        //把画笔设置为红色
        graphics.setColor(Color.WHITE);

        //在窗口中填充一个矩形
        //        在窗口中的坐标   矩形的宽度和高度
        graphics.fillRect(x,y,WIDTH,HEIGHT);

        //把画笔原来的颜色还原
        graphics.setColor(color);

        //移动的方法
        move();
    }

    private void move() {
        if(!moving){
            return;
        }
        switch (dir){
            case LEFT :
                x -= SPEED;
                System.out.println("向左");
                break;
            case RIGHT :
                x += SPEED;
                System.out.println("向右");
                break;
            case UP :
                y -= SPEED;
                System.out.println("向上");
                break;
            case DOWN :
                y += SPEED;
                System.out.println("向下");
                break;
        }
    }

    //坦克开火的方法
    public void fire() {
        //子弹的位置和方向和坦克一样
        tankFrame.bullet = new Bullet(this.x,this.y,this.dir);
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }


}
