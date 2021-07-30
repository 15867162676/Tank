import java.awt.*;
import java.util.Random;

/**
 * @author TF014268
 * @description 坦克类
 * @since 2021/7/27 0027 19:00
 */
public class Tank {
    //设置坦克的尺寸
    private int x;
    private int y;
    //坦克的存活状态
    private boolean live = true;

    //分组  我方  敌方
    private Group group = Group.BAD;

    //敌人随机发射子弹
    private Random random = new Random();

    //设置坦克的大小--获取图片大小
    public static int WIDTH = ResourceMgr.tankU.getWidth();
    public static int HEIGHT = ResourceMgr.tankU.getHeight();
    //持有一个游戏界面类的引用
    private TankFrame tankFrame = null;

    //设置坦克的初始方向
    private Dir dir;
    //坦克每次移动的距离
    private static final int SPEED = 2;
    //坦克是否是移动的
    private boolean moving = true;

    public Tank(int x, int y, Dir dir,Group group,TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tankFrame = tankFrame;
    }

    //使用画笔绘画坦克
    public void paint(Graphics graphics){
        //坦克的存活状态为消失，则删除
        //坦克删除后，当重新绘制游戏界面的时候就不再显示他了
        if(!live){
            tankFrame.tankList.remove(this);
            return;
        }

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

        //敌人的坦克随机发射子弹
        if(random.nextInt(10) > 8 && this.group==Group.BAD){
            this.fire();
        }
    }

    //坦克开火的方法
    public void fire() {
        //计算子弹的位置
        int bX = this.x+ (WIDTH/2) - Bullet.WIDTH/2;
        int bY = this.y+ (HEIGHT/2) - Bullet.HEIGHT/2;
        //子弹的位置和方向和坦克一样
        tankFrame.bulletList.add(new Bullet(bX,bY,this.dir,this.group,this.tankFrame));
    }

    //坦克消失
    public void die() {
        this.live = false;
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }
}
