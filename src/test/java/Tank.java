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

    //设置坦克的初始方向
    private Dir dir;
    //坦克每次移动的距离
    private static final int SPEED = 10;

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    //使用画笔绘画坦克
    public void paint(Graphics graphics){
        //在窗口中填充一个矩形
        //                  在窗口中的坐标   矩形的宽度和高度
        graphics.fillRect(x,y,20,30);

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

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }
}
