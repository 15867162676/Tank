import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author TF014268
 * @description test
 * @since 2021/7/28 0028 16:01
 */
public class MyTest22 {
    @Test
    public void test2() throws IOException {
        Logger log1 = Logger.getLogger("test1");
        log1.setLevel(Level.INFO);

//        Logger log2 = Logger.getLogger("test1");
//        System.out.println(log1==log2);
//        System.out.println("---------look---------");

        Logger log3 = Logger.getLogger("test2");

        //控制台控制器
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.ALL);
        log1.addHandler(ch);

        //文件控制器
        FileHandler fh = new FileHandler("E:\\GitLabMavenWorkSpace\\Tank\\Tank\\src\\test\\java\\myLog.log");
//        fh.setLevel(Level.ALL);
        log3.addHandler(fh);

        log1.info("log1--info");
        log3.info("log3--info");
        System.out.println("------------打印了吗------------");

        log1.fine("log1--fine");
        log3.fine("log3--fine");
    }


    @Test
    public void test1(){
        Logger logger = Logger.getLogger(MyTest22.class.getName());
        logger.setLevel(Level.ALL);

        logger.info("这个info");
        logger.warning("这个warning");
//        logger.
    }



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
