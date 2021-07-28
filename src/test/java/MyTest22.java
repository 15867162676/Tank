import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author TF014268
 * @description test
 * @since 2021/7/28 0028 16:01
 */
public class MyTest22 {
    public static void main(String[] args) {
        BufferedImage read = null;
        try {
//            read = ImageIO.read(new File("E:\\GitLabMavenWorkSpace\\Tank\\src\\images\\bulletD.gif"));
//            System.out.println(read.toString());
//            System.out.println("------------");

            read = ImageIO.read(MyTest22.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        System.out.println(read.toString());
    }


}
