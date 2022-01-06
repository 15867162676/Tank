package MyThread;

/**
 * @author TF014268
 * @description runnable
 * @since 2021/9/9 0009 15:54
 *
 * 1.实现Runnable接口
 * 2.重写run方法
 * 3.创建Thread对象，将刚刚创建好的runnable的子类实现作为thread的构造参数
 * 4.通过thread.start()进行启动
 *
 * 使用了代理设计模式
 */
public class RunnableDemo implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName() + "--" + i);
        }
    }

    public static void main(String[] args) {
        RunnableDemo runnableDemo = new RunnableDemo();
        Thread thread = new Thread(runnableDemo);
        thread.start();

        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName() + "**" + i);
        }
    }
}
