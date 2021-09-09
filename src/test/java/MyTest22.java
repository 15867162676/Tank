import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
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

    //输出到文件中
    @Test
    public void test3(){
        File file = new File("F://abc.txt");
        OutputStreamWriter osw = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            osw = new OutputStreamWriter(fos,"utf-8");
            osw.write("9");
            osw.write("12马士兵abc");
//            osw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {

            if(osw!=null){
                try {
                    osw.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            if(fos!=null){
                System.out.println("走进来了");
                try {
                    fos.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

        }
    }

    //从文件中读取
    @Test
    public void test4() {
        File file = new File("F://abc.txt");
        FileInputStream fis = null;
        InputStreamReader isr = null;

        try {
            char[] zhu = new char[1024];
            fis = new FileInputStream(file);

            isr = new InputStreamReader(fis);
            int len = 0;
            while((len=isr.read(zhu))!=-1){
                String mString = new String(zhu,0,len);
                System.out.print(mString);
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }finally {
            if(fis!=null){
                System.out.println("关闭fis");
                try {
                    fis.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            if(isr!=null){
                System.out.println("关闭isr");
                try {
                    isr.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

        }
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


    //跳过一行
    @Test
    public void test5(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader("F:/aa.txt"));  //读取文件
            bw = new BufferedWriter(new FileWriter("F:/cc.txt"));  //写文件
            String line = null;
            while((line = br.readLine()) != null){

                bw.write(line);
                if(line.equals("d")){
                    br.skip(1);
                }
                bw.newLine();  //写入行分隔符（换行）
            }
            System.out.println("over");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{
                if(br !=null){
                    br.close();
                }
                if(bw !=null){
                    bw.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test6(){
        //数据输入流和输出流
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;

        File file = new File("f://bb.txt");

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(file);
            dataOutputStream = new DataOutputStream(fileOutputStream);

            //boolean  int  string  类型顺序输出
            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeInt(123);
            dataOutputStream.writeUTF("字符串");

            System.out.println("---------分割线---------");

            fileInputStream = new FileInputStream(file);
            dataInputStream = new DataInputStream(fileInputStream);

            //读取的类型的顺序要和写入的顺序一样   boolean  int  string
            System.out.println(dataInputStream.readBoolean());
            System.out.println(dataInputStream.readInt());
            System.out.println(dataInputStream.readUTF());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if(null!=fileOutputStream){
                try {
                    fileOutputStream.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

            if(null!=dataOutputStream){
                try {
                    dataOutputStream.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

            if(null!=fileInputStream){
                try {
                    fileInputStream.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

            if(null!=dataInputStream){
                try {
                    dataInputStream.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test7(){
        List<Integer> list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        List<Integer> list2 = new ArrayList();
        list2.add(6);
        list2.add(2);
        list2.add(8);
        list2.add(4);
        list2.add(5);

        List<Integer> insertList = new ArrayList<>();
        List<Integer> deleteList = new ArrayList<>();

        for(int i=0;i<list1.size();i++){
            int a = list1.get(i);

            for(int j=0;j<list2.size();j++){
                int b=list2.get(j);
                if(a==b){
//                    list1.remove(a);
//                    list2.remove(b);
                    break;
                }

                if(j==list2.size()-1){
                    insertList.add(a);
                }
            }
        }

        list1.stream().forEach(System.out::println);
        System.out.println("-----------");
        list2.stream().forEach(System.out::println);

    }
}
