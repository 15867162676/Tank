import java.awt.*;

/**
 * @author TF014268
 * @description 子弹类
 * @since 2021/7/27 0027 20:32
 */
public class Bullet {
    //设置子弹的速度
    private static final int SPEED = 5;
    //设置子弹的大小--获取图片大小
    public static int WIDTH = ResourceMgr.bulletU.getWidth();
    public static int HEIGHT = ResourceMgr.bulletU.getHeight();

    //子弹的位置
    private int x,y;
    //子弹的方向
    private Dir dir;
    //子弹的存活状态
    private boolean live = true;
    //引用游戏界面
    private TankFrame tankFrame = null;

    public Bullet(int x, int y, Dir dir,TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }

    //用画笔画子弹
    public void paint(Graphics graphics){
        switch (dir){
            case LEFT:
                graphics.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case RIGHT:
                graphics.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            case DOWN:
                graphics.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
            case UP:
                graphics.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
            default:
                graphics.drawImage(ResourceMgr.bulletU,x,y,null);
        }

        move();
    }

    //移动的方法
    private void move() {
        //子弹的存活状态为消失，则删除
        if(!this.live){
            tankFrame.bulletList.remove(this);
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

        //如果子弹超出游戏界面，把存活状态设为false
        if(x<0 || y<0 || x>tankFrame.getWidth() || y>tankFrame.getHeight()){
            this.live = false;
        }
    }

    //子弹撞击坦克
    public void toHit(Tank tank) {
        //子弹的位置
        Rectangle rectangle1 = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
        //坦克的位置
        Rectangle rectangle2 = new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);
        if(rectangle1.intersects(rectangle2)){
            //撞击了，子弹消失，坦克消失
            tank.die();
            this.die();
        }
    }

    //子弹消失
    private void die() {
        this.live = false;
    }
}
