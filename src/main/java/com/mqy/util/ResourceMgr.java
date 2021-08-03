package com.mqy.util;

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
    public static BufferedImage[] goodRedTanks = new BufferedImage[4];
    //四个方向的好坦克图片--绿色
    public static BufferedImage[] goodGreenTanks = new BufferedImage[4];

    //四个方向的坏坦克图片--红色--按上下左右的顺序放
    public static BufferedImage[] badRedTanks = new BufferedImage[4];
    //四个方向的坏坦克图片--绿色
    public static BufferedImage[] badGreenTanks = new BufferedImage[4];
    //四个方向的子弹图片
    public static BufferedImage bulletL,bulletR,bulletU,bulletD;
    //坦克爆炸的图片
    public static BufferedImage[] bufferedImages = new BufferedImage[16];

    //抽象工厂--坦克样式---------------开始
    public static BufferedImage[] rectTanks = new BufferedImage[4];
    public static BufferedImage rectBullet;
    public static BufferedImage[] rectEx = new BufferedImage[11];
    //抽象工厂--坦克样式---------------结束

    static{
        try {
            //抽象工厂--坦克样式---------------开始
            rectTanks[0] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            rectTanks[1] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
            rectTanks[2] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            rectTanks[3] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));

            rectBullet = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            for(int i=0;i<rectEx.length;i++){
                rectEx[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/" + (i) + ".gif"));
            }
            //抽象工厂--坦克样式---------------结束


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
