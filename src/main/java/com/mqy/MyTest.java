package com.mqy;

import com.mqy.PropertyMgr;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TF014268
 * @description test
 * @since 2021/7/26 0026 16:36
 */
public class MyTest {

    public static void main(String[] args) throws Exception {
        TankFrame tankFrame = new TankFrame();

        //爆炸的声音
//        new Thread(() -> new Audio("addio/war1.wav").loop()).start();

        while (true){
            //窗口重绘的的间隔时间
            Thread.sleep(50);
            //调用窗口重绘接口  会自动调用paint(Graphics graphics)方法
            tankFrame.repaint();
        }
    }

    @Test
    public void mytest3(){
        System.out.println(fmtMicrometer(new BigDecimal("123456789")));
        System.out.println(fmtMicrometer(new BigDecimal("12345678.9")));
        System.out.println(fmtMicrometer(new BigDecimal("0.123456789")));
    }

    /**
     * 格式化数字为千分位显示；
     * @param bigDecimal 要格式化的数字；
     * @return
     */
    public static String fmtMicrometer(BigDecimal bigDecimal)
    {
        String text = bigDecimal.toString();
        DecimalFormat df = null;
        if(text.indexOf(".") > 0)
        {
            if(text.length() - text.indexOf(".")-1 == 0)
            {
                df = new DecimalFormat("###,##0.");
            }else if(text.length() - text.indexOf(".")-1 == 1)
            {
                df = new DecimalFormat("###,##0.0");
            }else
            {
                df = new DecimalFormat("###,##0.0000");
            }
        }else
        {
            df = new DecimalFormat("###,##0");
        }
//        double number = 0.0;
//        try {
//            number = Double.parseDouble(text);
//        } catch (Exception e) {
//            number = 0.0;
//        }
        return df.format(bigDecimal);
    }

    @Test
    public void test4(){
        BigDecimal[] list = new BigDecimal[9];
//        System.out.println(list.size());
//        for(int i=0;i<list.size();i++){
//            list.add(i + "i");
//        }

        System.out.println(list[8]);
    }

    @Test
    public void test5(){
        List<String> list = new ArrayList();
        list.add("第10期");
        list.add("第101期");
        list.add("第100期");
        list.add("第2期");
        list.add("第11期");
        list.add("第3期");
        list.add("第15期");

        for(int i=0;i<list.size();i++){
            String msg = list.get(i);
             msg= msg.substring(1,msg.length()-1);
            System.out.println(msg);
        }

//        list.stream().sorted().forEach(System.out::println);
    }
}
