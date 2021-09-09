import org.junit.Test;

import java.io.*;
import java.net.URL;

/**
 * @author TF014268
 * @description test
 * @since 2021/9/7 0007 11:01
 */
public class MyTest33 {

    @Test
    public void test9(){
        RandomAccessFile randomAccessFile = null;
        File file = new File("F://fhq.txt");

        //文件总长度
        int length = (int) file.length();
        System.out.println("文件总长度：" + length);
        //每块1024
        int kuaiLength = 1024;
        //每块1024，计算出要分多少块
        //Math.ceil向上取整
        int kuai = (int) Math.ceil(length * 1.0 / kuaiLength);

        for(int i=0;i<kuai;i++){
            //块开始的位置（此处不用+1）
            int start = i*kuaiLength;

            int chang = 0;
            if(length>kuaiLength){
                chang = kuaiLength;
            }else{
                chang = length;
            }
            length -= kuaiLength;

            System.out.printf("第%d块，偏移%d位置,长度为%d",(i+1),start,chang);
            System.out.print("\n");

            //读取文件内容
//            readTxt(start,chang,file);
        }

    }

    /**
     * 分块读取文件中的内容
     * @param start  块  开始的位置
     * @param chang  块  的长度
     * @param file   文件
     */
    private void readTxt(int start,int chang,File file) {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(file,"r");
            randomAccessFile.seek(start);
            byte[] bytes = new byte[1024];
            int length = 0;
            while( (length=randomAccessFile.read(bytes)) != -1){
                System.out.println(new String(bytes,0,chang,"utf-8"));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if(null!=randomAccessFile) {
                try {
                    randomAccessFile.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test10(){
        File file = new File("f://aa.txt");
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(file,"r");
            randomAccessFile.seek(0);
            System.out.println("seek(0)时，第一个位置的元素是：");
            System.out.println((char)randomAccessFile.read());
            System.out.println("------------------");

            randomAccessFile = new RandomAccessFile(file,"r");
            randomAccessFile.seek(1);
            System.out.println("seek(1)时，第一个位置的元素是：");
            System.out.println((char)randomAccessFile.read());
            System.out.println("------------------");

            randomAccessFile = new RandomAccessFile(file,"r");
            randomAccessFile.seek(2);
            System.out.println("seek(2)时，第一个位置的元素是：");
            System.out.println((char)randomAccessFile.read());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if(null!=randomAccessFile){
                try {
                    randomAccessFile.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }

    }

    @Test
    public void test1(){
        char[] chars = "我的测试".toCharArray();
        CharArrayReader charArrayReader = new CharArrayReader(chars);

        try {
            int read = 0;
            while((read=charArrayReader.read())!=-1){
                System.out.println((char)read);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }finally {
            charArrayReader.close();
        }
    }

    @Test
    public void test2(){
        char[] chars = "我的测试".toCharArray();
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        //写入缓冲区
        charArrayWriter.write(chars,0,chars.length);
        System.out.println(charArrayWriter);
        System.out.println("----------------");
        charArrayWriter.write(99);
        System.out.println(charArrayWriter);
        System.out.println("----------------");

        //追加
        charArrayWriter.append('a');
        System.out.println(charArrayWriter);
        charArrayWriter.close();
    }

    @Test
    public void test3(){
        //带缓冲区的字符输入流
        BufferedReader bufferedReader = null;
        Reader reader = null;

        try {
            reader = new FileReader("F://aa.txt");
            bufferedReader = new BufferedReader(reader);
            String read = null;
            while((read=bufferedReader.readLine())!=null){
                System.out.println(read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if(null!=bufferedReader){
                try {
                    bufferedReader.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

            if(null!=reader){
                try {
                    reader.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test4(){
        //带缓冲区的字符输出流
        BufferedWriter bufferedWriter = null;
        Writer writer = null;

        try {
            writer = new FileWriter("F://aa.txt");
            bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("abdsfdsf");
            bufferedWriter.newLine();
            bufferedWriter.append("etewfdsfvdsfewghfgvds");
            bufferedWriter.newLine();
            bufferedWriter.write("0987654321");
            //从缓冲区写入到文件中
            bufferedWriter.flush();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if(null!=bufferedWriter){
                try {
                    bufferedWriter.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

            if(null!=writer){
                try {
                    writer.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test5(){
        //带缓冲区的字符输出流
        try(Writer writer = new FileWriter("F://aa.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            bufferedWriter.write("abdsfdsf");
            bufferedWriter.newLine();
            bufferedWriter.append("etewfdsfvdsfewghfgvds");
            bufferedWriter.newLine();
            bufferedWriter.write("0987654321111111");
            //从缓冲区写入到文件中
            bufferedWriter.flush();
            System.out.println("over");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Test
    public void test6(){
        //读取网页上的内容，并输出到本地文件中
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new URL("https://www.baidu.com").openStream(),"utf-8"));
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("f://baidu.html")));

            String read = null;
            while((read=bufferedReader.readLine())!=null){
                bufferedWriter.write(read);
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            System.out.println("over");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if(null!=bufferedReader){
                try {
                    bufferedReader.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

            if(null!=bufferedWriter){
                try {
                    bufferedWriter.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test7(){
        PrintStream printStream = null;
        try {
            printStream = new PrintStream(System.out);
            printStream.write("测试一下".getBytes());
            printStream.print("yyy");
            printStream.println("zzz");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            if(null!=printStream){
                printStream.close();
            }
        }

        System.out.println("-------------");

        //格式化输出
        /*
         * %s  代表字符串
         * %d  代表整数
         * %f  代表浮点数
         * */
        System.out.printf("%s--%d----%.2f","aaa",888,1.23456f);
        //System.out  就是  PrintStream
    }

    @Test
    public void test8(){
        System.out.println("**********");
        System.out.println("test");
        System.err.println("error");
    }
}
