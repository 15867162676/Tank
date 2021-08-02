import java.awt.*;
import java.util.List;

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

    //分组  我方  敌方
    private Group group;

    //子弹的位置
    private int x,y;
    //子弹的方向
    private Dir dir;
    //子弹的存活状态
    private boolean live = true;

    //撞击检测的位置
    Rectangle rect = new Rectangle();

    //引用游戏界面
    private TankFrame tankFrame = null;

    public Bullet(int x, int y, Dir dir,Group group,TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tankFrame = tankFrame;

        //初始化碰撞检测的rect
        rect.x = x;
        rect.y = y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
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
                break;
            case RIGHT :
                x += SPEED;
                break;
            case UP :
                y -= SPEED;
                break;
            case DOWN :
                y += SPEED;
                break;
        }

        //移动后，改变碰撞检测的位置
        rect.x = this.x;
        rect.y = this.y;

        //如果子弹超出游戏界面，把存活状态设为false
        if(x<0 || y<0 || x>tankFrame.getWidth() || y>tankFrame.getHeight()){
            this.live = false;
        }
    }

    //子弹撞击坦克  撞击返回true
    public void toHit(Tank tank) {
        //如果是自己方的，不会打死
        if(this.group==tank.getGroup()){
            return;
        }
        /*如果坦克已经死了，就不再检测碰撞。
        多颗子弹碰撞同一个坦克会出现多个爆炸图片的bug*/
        if(tank.isLive()==false){
            return;
        }

        //子弹的位置和坦克的位置比较
        if(rect.intersects(tank.rect)){
            //撞击了，子弹消失，坦克消失
            tank.die();
            this.die();

            //计算爆炸的位置--在坦克的中心位置上爆炸
            //坦克的位置坐标 + 坦克位置的一半 - 爆炸图片的一半
            int eX = tank.getX() + (Tank.WIDTH/2) - Explode.WIDTH/2;
            int eY = tank.getY() + (Tank.HEIGHT/2) - Explode.HEIGHT/2;
            //显示爆炸
            this.tankFrame.explodeList.add(new Explode(eX,eY,this.tankFrame));
        }
    }

    //子弹消失
    private void die() {
        this.live = false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
