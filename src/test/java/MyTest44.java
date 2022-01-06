import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author TF014268
 * @description test
 * @since 2021/9/9 0009 14:13
 */
public class MyTest44 {
    public static void main(String[] args) throws InterruptedException {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("JVM退出了")));

        Thread thread = new Thread(() ->{
            while(true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("正在运行中...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        TimeUnit.SECONDS.sleep(2);

        System.out.println("主线程即将退出");
    }

    @Test
    public void test1() throws InterruptedException {
        Thread thread = new Thread(() ->{
            while(true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("正在运行中...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        TimeUnit.SECONDS.sleep(2);

        System.out.println("主线程即将退出");
    }

    @Test
    public void test2() throws InterruptedException {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("JVM退出了")));

        Thread thread = new Thread(() ->{
            while(true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("正在运行中...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        //设置成守护线程
        thread.setDaemon(true);
        thread.start();
        TimeUnit.SECONDS.sleep(2);

        System.out.println("主线程即将退出");
    }
}
