import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author TF014268
 * @description 坦克大战窗口
 * @since 2021/7/27 0027 14:49
 */
public class TankFrame extends Frame {
    //创建一个坦克
    Tank tank = new Tank(300,200,Dir.DOWN);
    //创建子弹
    Bullet bullet = new Bullet(320,200,Dir.DOWN);

    public TankFrame(){
        //设置窗口大小
        this.setSize(800,600);
        //设置窗口不能拖拽改变大小
        this.setResizable(false);
        //设置窗口标题
        this.setTitle("坦克游戏");
        //显示一个小窗口
        this.setVisible(true);

        //设置键盘监听器
        this.addKeyListener(new MyKeyListener());

        //设置窗口可关闭
        //监听  点击  关闭小叉子事件
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //系统退出
                System.exit(0);
            }
        });
    }

    //此方法会被系统自动调用
    //需要重新绘制窗口的时候调用，比如窗口切换回来、窗口改变大小
    @Override
    public void paint(Graphics graphics){
        //把画笔交给坦克类自己去画
        tank.paint(graphics);
        //把画笔交给子弹类自己去画
        bullet.paint(graphics);
    }

    //按键监听器内部类
    class MyKeyListener extends KeyAdapter {

        boolean bL = false;  //向左键
        boolean bR = false;  //向右键
        boolean bU = false;  //向上键
        boolean bD = false;  //向下键

        //某个按键按下去的事件
        @Override
        public void keyPressed(KeyEvent e) {
            //按下的具体是哪个键
            int keyCode = e.getKeyCode();
            switch(keyCode){
                case KeyEvent.VK_LEFT:  //按下的是向左的键
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
            }
            //设置坦克的方向
            setMainTankDir();
        }

        //设置坦克的方向
        private void setMainTankDir(){
            //如果四个方向都没点击，坦克就是静止的
            if(!bL && !bR && !bU && !bD){
                tank.setMoving(false);
                return;
            }
            
            tank.setMoving(true);
            if(bL){
                tank.setDir(Dir.LEFT);
            }
            if(bR){
                tank.setDir(Dir.RIGHT);
            }
            if(bU){
                tank.setDir(Dir.UP);
            }
            if(bD){
                tank.setDir(Dir.DOWN);
            }
        }

        //某个按键弹起来的事件
        @Override
        public void keyReleased(KeyEvent e) {
            //按下的具体是哪个键
            int keyCode = e.getKeyCode();
            switch(keyCode){
                case KeyEvent.VK_LEFT:  //按下的是向左的键
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                default:
            }
            //设置坦克的方向
            setMainTankDir();
        }

    }
}
