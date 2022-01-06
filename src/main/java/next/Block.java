package next;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author TF014268
 * @description 分块查找
 * @since 2021/9/26 0026 19:12
 */
public class Block {

    /**
     *
     * @param shus  数组
     * @param map   块的情况
     * @param num   要查找的数字
     */
    public static void cha(int[] shus,Map<Integer,Integer> map,int num){
        Set<Integer> integers = map.keySet();

        //初始化要查找的开始下标和结束下标
        int start = 0;
        int end = shus.length-1;

        //如果只有一个块，那么直接顺序查找
        if(map.size()==1){
            blockCha(shus,num,start,end);
            return;
        }

        //此标识用于获取要查找的结束下标
        boolean mark = false;

        //块之间是有顺序的，则从第一个块开始找，比这个块最大的值小，则要查找的数据落在这个块中。
        for(Integer index : integers){
            if(num <= map.get(index)){
                //要查找的数据在此段中
                start = index;
                mark = true;
                continue;
            }

            if(mark){
                end = index - 1;
                break;
            }
        }

        //这个数字比最大的数字还大，不在任何块中
        if((end-start+1) == shus.length){
            System.out.println("不存在这个数！！！");
            return;
        }

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
        int[] shus = {4,10,7,6,8,  25,22,15,30,16,  45,46,47,50,41,42,43};

        /*key中存放的是此块开始的下标
        value中存放的是此块中最大的数字
        */
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,10);
        map.put(5,30);
        map.put(10,50);
        //查找15
        int num = 43;

        cha(shus,map,num);
    }
}
