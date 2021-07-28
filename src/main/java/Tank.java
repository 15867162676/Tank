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

    //设置坦克的大小--获取图片大小
    public static int WIDTH = ResourceMgr.tankU.getWidth();
    public static int HEIGHT = ResourceMgr.tankU.getHeight();
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
        switch (dir){
            case LEFT:
                graphics.drawImage(ResourceMgr.tankL,x,y,null);
                break;
            case RIGHT:
                graphics.drawImage(ResourceMgr.tankR,x,y,null);
                break;
            case DOWN:
                graphics.drawImage(ResourceMgr.tankD,x,y,null);
                break;
            case UP:
                graphics.drawImage(ResourceMgr.tankU,x,y,null);
                break;
            default:
                graphics.drawImage(ResourceMgr.tankU,x,y,null);
        }


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
        //计算子弹的位置
        int bX = this.x+ (WIDTH/2) - Bullet.WIDTH/2;
        int bY = this.y+ (HEIGHT/2) - Bullet.HEIGHT/2;
        //子弹的位置和方向和坦克一样
        tankFrame.bulletList.add(new Bullet(bX,bY,this.dir,this.tankFrame));
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
