package MyThread;

/**
 * @author TF014268
 * @description test
 * @since 2021/9/9 0009 16:34
 */
public class MyTest extends Thread{
    @Override
    public void run() {
        for(int i=0;i<=100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName() + "--" + i);
            }
        }
    }

    public static void main(String[] args) {
        MyTest myTest = new MyTest();
        myTest.start();
    }
}

class MyTest2 implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<=100;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName() + "**" + i);
            }
        }
    }

    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();
        Thread thread = new Thread(myTest2);
        thread.start();
    }
}
