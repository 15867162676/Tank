package next;

import java.util.*;

/**
 * @author TF014268
 * @description 分块查找
 * @since 2021/9/26 0026 19:12
 */
public class Block2 {

    /**
     * 折半查找数字落的块
     * @param num  要查找的数字
     */
    public static int chaHalf(List<Integer> valueList,int num){
        //索引表的开始下标
        int start = 0;
        //索引表的结束下标
        int end = valueList.size()-1;
        if(num > valueList.get(end)){
            System.out.println("数组中没有此数字");
            return -1;
        }

        if(num <= valueList.get(start)){
            //数据落在此块中
            return start;
        }

        /**
         * 这里的循环条件很巧妙
         *
         * 比如有3个分块， 0 1 2  max分别为 10 30 50
         * 数据落在下标为1的块中
         * 第一次折半查找  mid=1,但是要查找的数字num=15  15<30  所以走了end = mid-1  也就是end=1-1=0  此时start=0
         * 此时start=0  end=0
         *
         * 走第二次折半查找，mid=0  num=15  max=10 num>max  start = mid+1=0+1=1
         * 此时start=1  end=0
         *
         * 不符合循环条件了
         * 那么  (start + end + 1) / 2 = (0+1+1)  /2 = 1
         * 那么要查找的数据落在下标为1的块中
         */
        while(start <= end){
            System.out.println("折半查找一次------");
            int mid = (start+end) / 2;
            //这个块中最大的数
            int midShu = valueList.get(mid);
            if(midShu == num){
                return mid;
            }else if(midShu < num){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        int resultIndex = (start + end + 1) / 2;
        if (resultIndex >= valueList.size()) {
            resultIndex = -1;// 表示未找到
        }
        return resultIndex;
    }

    /**
     *
     * @param shus  数组
     * @param keyList
     * @param valueList  块的情况
     * @param num   要查找的数字
     */
    public static void cha(int[] shus,List<Integer> keyList,List<Integer> valueList,int num){

        int kuai = chaHalf(valueList,num);
        if(kuai == -1){
            System.out.println("没有此数字");
            return;
        }


        //初始化要查找的开始下标和结束下标
        int start = 0;
        int end = shus.length-1;

        //开始下标为  块的  开始下标
        start = keyList.get(kuai);
        if((kuai+1) < keyList.size()){
            end = keyList.get(kuai+1);
        }
        System.out.println("块的开始下标为：" + start);
        System.out.println("块的结束下标为：" + end);
        blockCha(shus,num,start,end);
    }

    /**
     *
     * @param shus  数组
     * @param num  要查找的数字
     * @param start  块的开始下标
     * @param end  块的结束下标
     */
    public static void blockCha(int[] shus,int num,int start,int end){
        for(int i = start;i <= end;i++){
            if(num == shus[i]){
                System.out.println("找到啦~~~~~~下标为：" + i);
                return;
            }
        }

        System.out.println("没有这个数字");
    }

    public static void main(String[] args) {
        /*第一块中最大的为10，共5个元素 A
        * 第二块中最大的为30，共5个元素 B
        * 第三块中最大的为50，共7个元素 C
        * ABC整体呈递增的顺序
        * */
        //            0  1 2 3 4   5  6  7  8  9    10 11 12 13 14 15 16
        int[] shus = {4,10,7,6,8,  25,22,15,30,16,  45,46,47,50,41,42,43};

        /*key中存放的是此块开始的下标
        value中存放的是此块中最大的数字
        */
        List<Integer> keyList = new ArrayList<>();
        keyList.add(0);
        keyList.add(5);
        keyList.add(10);

        List<Integer> valueList = new ArrayList<>();
        valueList.add(10);
        valueList.add(30);
        valueList.add(50);

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,10);
        map.put(5,30);
        map.put(10,50);
        //查找15
        int num = 15;

        cha(shus,keyList,valueList,num);
    }
}
