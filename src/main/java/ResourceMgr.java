import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author TF014268
 * @description 资源管理类
 * @since 2021/7/28 0028 16:28
 */
public class ResourceMgr {
    //四个方向的好坦克图片--红色--按上下左右的顺序放
    static BufferedImage[] goodRedTanks = new BufferedImage[4];
    //四个方向的好坦克图片--绿色
    static BufferedImage[] goodGreenTanks = new BufferedImage[4];

    //四个方向的坏坦克图片--红色--按上下左右的顺序放
    static BufferedImage[] badRedTanks = new BufferedImage[4];
    //四个方向的坏坦克图片--绿色
    static BufferedImage[] badGreenTanks = new BufferedImage[4];
    //四个方向的子弹图片
    static BufferedImage bulletL,bulletR,bulletU,bulletD;
    //坦克爆炸的图片
    static BufferedImage[] bufferedImages = new BufferedImage[16];

    static{
        try {
            //好坦克的方向
            goodRedTanks[0] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            goodRedTanks[1] = ImageUtil.rotateImage(goodRedTanks[0], 180);
            goodRedTanks[2] = ImageUtil.rotateImage(goodRedTanks[0], -90);
            goodRedTanks[3] = ImageUtil.rotateImage(goodRedTanks[0], 90);


            //好坦克的方向
            goodGreenTanks[0] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank2.png"));
            goodGreenTanks[1] = ImageUtil.rotateImage(goodGreenTanks[0], 180);
            goodGreenTanks[2] = ImageUtil.rotateImage(goodGreenTanks[0], -90);
            goodGreenTanks[3] = ImageUtil.rotateImage(goodGreenTanks[0], 90);


            //坏坦克的方向
            badRedTanks[0] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            badRedTanks[1] = ImageUtil.rotateImage(badRedTanks[0], 180);
            badRedTanks[2] = ImageUtil.rotateImage(badRedTanks[0], -90);
            badRedTanks[3] = ImageUtil.rotateImage(badRedTanks[0], 90);

            //坏坦克的方向
            badGreenTanks[0] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank2.png"));
            badGreenTanks[1] = ImageUtil.rotateImage(badGreenTanks[0], 180);
            badGreenTanks[2] = ImageUtil.rotateImage(badGreenTanks[0], -90);
            badGreenTanks[3] = ImageUtil.rotateImage(badGreenTanks[0], 90);

            //子弹的方向
            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
            bulletL = ImageUtil.rotateImage(bulletU, -90);
            bulletR = ImageUtil.rotateImage(bulletU, 90);
            bulletD = ImageUtil.rotateImage(bulletU, 180);

            //爆炸的图片读取
            for(int i=0;i<bufferedImages.length;i++){
                bufferedImages[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e" + (i+1) + ".gif"));
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
