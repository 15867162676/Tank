import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author TF014268
 * @description 资源管理类
 * @since 2021/7/28 0028 16:28
 */
public class ResourceMgr {
    //四个方向的坦克图片
    static BufferedImage tankL,tankR,tankU,tankD;
    //四个方向的子弹图片
    static BufferedImage bulletL,bulletR,bulletU,bulletD;
    //坦克爆炸的图片
    static BufferedImage[] bufferedImages = new BufferedImage[16];

    static{
        try {
            //坦克的方向
            tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));

            //子弹的方向
            bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));

            //爆炸的图片读取
            for(int i=0;i<bufferedImages.length;i++){
                bufferedImages[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e" + (i+1) + ".gif"));
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
