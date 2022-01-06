package sort;

/**
 * @author TF014268
 * @description 简单选择排序
 * @since 2021/10/13 0013 21:20
 */
public class XuanZhe {

    /**
     * 获取最小数的下标
     * @param shu  数组
     * @param start  这个范围的开始下标
     * @param end  这个范围的结束下标
     * @return
     */
    public static int getMin(int[] shu,int start,int end){
        //先把此范围第一个数设为最小的数
        int min = shu[start];
        //记录最小的数的下标
        int index = start;
        //这个范围开始的下标为start,先从第start+1位置的和start进行比较
        for(int i=start+1;i<=end;i++){
            //如果有比min的值还小的数
            if(shu[i] < min){
                min = shu[i];
                index = i;
            }
        }
        return index;
    }

    /**
     * 交换位置
     * @param index  这个范围的第一个数的下标
     * @param minIndex  这个范围最小的数的下标
     * @param shu  数组
     */
    public static void jiaoHuan(int index,int minIndex,int[] shu){
        int huan = shu[index];
        shu[index] = shu[minIndex];
        shu[minIndex] = huan;
    }

    //排序
    public static void sort(int[] shu){
        for(int i=0;i<shu.length;i++){
            //获取某个范围的最小的数的下标
            int minIndex = getMin(shu, i, shu.length - 1);
            //位置不一样才需要交换
            if(i != minIndex){
                //交换位置
                jiaoHuan(i, minIndex, shu);
            }
        }
    }

    //打印方法
    public static void print(int[] array){
        for(int a : array){
            System.out.print(a + "\t");
        }
    }

    public static void main(String[] args) {
        int[] shu = new int[]{3,5,1,4,2};
        sort(shu);
        print(shu);
    }
}
