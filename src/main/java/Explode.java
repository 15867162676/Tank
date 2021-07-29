import java.awt.*;

/**
 * @author TF014268
 * @description 爆炸类
 * @since 2021/7/27 0027 20:32
 */
public class Explode {

    //获取图片大小
    public static int WIDTH = ResourceMgr.bufferedImages[0].getWidth();
    public static int HEIGHT = ResourceMgr.bufferedImages[0].getHeight();

    //位置
    private int x,y;

    //播放到第几张图片了
    private int page = 0;

    //存活状态
    private boolean live = true;

    //引用游戏界面
    private TankFrame tankFrame = null;

    public Explode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
    }

    //用画笔画
    public void paint(Graphics graphics){
        graphics.drawImage(ResourceMgr.bufferedImages[page++],this.x,this.y,null);
        if(page >= ResourceMgr.bufferedImages.length){
            page = 0;
        }
    }

}
