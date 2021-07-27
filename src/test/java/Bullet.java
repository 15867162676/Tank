import java.awt.*;

/**
 * @author TF014268
 * @description 子弹类
 * @since 2021/7/27 0027 20:32
 */
public class Bullet {
    //设置子弹的速度
    private static final int SPEED = 2;
    //设置子弹的大小
    private static int WIDTH = 30;
    private static int HEIGHT = 30;

    //子弹的位置
    private int x,y;
    //子弹的方向
    private Dir dir;

    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    //用画笔画子弹
    public void paint(Graphics graphics){
        //获取画笔原来的颜色
        Color color = graphics.getColor();
        //把画笔设置为红色
        graphics.setColor(Color.RED);
        //画出一个圆形的子弹
        graphics.fillOval(x,y,WIDTH,HEIGHT);
        //把画笔原来的颜色还原
        graphics.setColor(color);

        move();
    }

    //移动的方法
    private void move() {
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
}
