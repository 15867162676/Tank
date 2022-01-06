package MyThread;

/**
 * @author TF014268
 * @description 线程demo
 * @since 2021/9/9 0009 15:12
 *
 * 实现多线程的时候：
 * 1.需要继承Thread类
 * 2.必须重写run方法，指的是核心执行的逻辑
 * 3.线程在启动的时候，不要直接调用run方法，而是要通过start方法来调用
 * 4.运行相同的代码，出来的结果可能不一样，原因在于多线程谁先抢占资源无法人为控制。
 */
public class ThreadDemo extends Thread{
    @Override
    public void run() {
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName() + "--" + i);
        }
    }

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();

        for(int i=0;i<3;i++){
            System.out.println(Thread.currentThread().getName() + "**" + i);
        }
    }
}
