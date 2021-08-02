import java.awt.*;
import java.awt.image.BufferedImage;
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
    public static int WIDTH = ResourceMgr.goodRedTanks[0].getWidth();
    public static int HEIGHT = ResourceMgr.goodRedTanks[0].getHeight();

    //撞击检测的位置
    Rectangle rect = new Rectangle();

    //持有一个游戏界面类的引用
    private TankFrame tankFrame = null;

    //设置坦克的初始方向
    private Dir dir;
    //坦克每次移动的距离
    private static final int SPEED = 3;
    //坦克是否是移动的
    private boolean moving = true;
    //坦克的颜色
    private Color tankColor = Color.RED;

    //开火的策略
    private FireStrategy fireStrategy;


    public Tank(int x, int y, Dir dir,Group group,TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tankFrame = tankFrame;

        rect.x = x;
        rect.y = y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        if(this.group == Group.BAD){
            fireStrategy = new DefaultFireStrategy();
        }else{
            fireStrategy = new FourDirFireStrategy();
        }
    }

    //使用画笔绘画坦克
    public void paint(Graphics graphics){
        //坦克的存活状态为消失，则删除
        //坦克删除后，当重新绘制游戏界面的时候就不再显示他了
        if(!live){
            tankFrame.tankList.remove(this);
            return;
        }
        drawTank(graphics);
        //移动的方法
        move();
    }

    //画坦克的方法
    private void drawTank(Graphics graphics){
        BufferedImage bufferedImage = null;
        //坏坦克
        if(this.group==Group.BAD){
            switch (dir){
                case UP:
                    getBadTankImage(0,graphics);
                    break;
                case DOWN:
                    getBadTankImage(1,graphics);
                    break;
                case LEFT:
                    getBadTankImage(2,graphics);
                    break;
                case RIGHT:
                    getBadTankImage(3,graphics);
                    break;
                default:
                    getBadTankImage(0,graphics);
            }
            return;
        }

        switch (dir){
            case UP:
                getGoodTankImage(0,graphics);
                break;
            case DOWN:
                getGoodTankImage(1,graphics);
                break;
            case LEFT:
                getGoodTankImage(2,graphics);
                break;
            case RIGHT:
                getGoodTankImage(3,graphics);
                break;
            default:
                getGoodTankImage(0,graphics);
        }
        graphics.drawImage(bufferedImage,x,y,null);
    }

    //获取好坦克的图片（红色  绿色切换）
    private void getGoodTankImage(int index,Graphics graphics){
        BufferedImage bufferedImage = null;
        if(this.tankColor== Color.RED){
            //坦克为红色，这里设置成绿色
            bufferedImage = ResourceMgr.goodGreenTanks[index];
            this.tankColor = Color.GREEN;
        }else{
            //坦克为绿色，这里设置成红色
            bufferedImage = ResourceMgr.goodRedTanks[index];
            this.tankColor = Color.RED;
        }
        graphics.drawImage(bufferedImage,x,y,null);
    }

    //获取坏坦克的图片（红色  绿色切换）
    private void getBadTankImage(int index,Graphics graphics){
        BufferedImage bufferedImage = null;
        if(this.tankColor== Color.RED){
            //坦克为红色，这里设置成绿色
            bufferedImage = ResourceMgr.badGreenTanks[index];
            this.tankColor = Color.GREEN;
        }else{
            //坦克为绿色，这里设置成红色
            bufferedImage = ResourceMgr.badRedTanks[index];
            this.tankColor = Color.RED;
        }
        graphics.drawImage(bufferedImage,x,y,null);
    }

    private void move() {
        if(!moving){
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

        if(this.group==Group.BAD){
            //敌人的坦克随机发射子弹
            if(random.nextInt(10) > 8){
                this.fire();
            }

            if(random.nextInt(10) > 8){
                //敌人的坦克随机方向走
                randomDir();
            }
        }

        //如果坦克超出游戏界面，需要掉头
        checkTankOutFrame();

        //在超出界面判断的方法后再把 撞击检测rect的坐标更新
        rect.x = this.x;
        rect.y = this.y;
    }

    //校验坦克是否即将跑出游戏界面
    private void checkTankOutFrame(){
        int minX = Tank.WIDTH + 20;  //最小的x值
        int minY = Tank.HEIGHT + 20;  //最小的y值
        int maxX = tankFrame.getWidth() - Tank.WIDTH - 20;  //最大的x值
        int maxY = tankFrame.getHeight() - Tank.HEIGHT - 20;  //最大的y值

        if(x <= minX){
            this.x = minX;
        }
        if(y <= minY){
            this.y = minY;
        }
        if(x >= maxX){
            this.x = maxX;
        }
        if(y >= maxY){
            this.y = maxY;
        }
    }

    //敌人的坦克随机方向走
    private void randomDir() {
        /*去0-4之间的整数，不包含4
        Dir枚举中有4个值，values()返回的是一个数组，
        这里通过随机数获取方向
        类似：
        Dir.values()[0]  Dir.values()[1]  Dir.values()[2]  Dir.values()[3]
        */
        this.dir = Dir.values()[random.nextInt(4)];
    }

    //坦克开火的方法--策略模式
    public void fire() {
        fireStrategy.fire(this);
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

    public TankFrame getTankFrame() {
        return tankFrame;
    }

    public void setTankFrame(TankFrame tankFrame) {
        this.tankFrame = tankFrame;
    }
}
