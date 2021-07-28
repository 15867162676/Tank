/**
 * @author TF014268
 * @description test
 * @since 2021/7/26 0026 16:36
 */
public class MyTest {

    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();

        for(int i=0;i<5;i++){
            tankFrame.tankList.add(new Tank(50 + i*50,200 +i*50,Dir.DOWN,tankFrame));
        }

        while (true){
            //窗口重绘的的间隔时间
            Thread.sleep(50);
            //调用窗口重绘接口  会自动调用paint(Graphics graphics)方法
            tankFrame.repaint();
        }
    }
}
