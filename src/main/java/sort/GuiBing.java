package sort;

/**
 * @author TF014268
 * @description 归并排序
 * @since 2021/10/14 0014 15:07
 */
public class GuiBing {

    //打印方法
    public static void print(int[] array){
        for(int a : array){
            System.out.print(a + "\t");
        }
    }

    /**
     * 生成拆分的数组
     * @param length 要生成的数组的长度
     * @param shu 要拆分的数组
     * @param start 拆分的开始下标
     * @param end  拆分的结束下标
     * @return
     */
    private static int[] createChaiShu(int length, int[] shu, int start, int end){
        int[] chaiShu1 = new int[length];
        int i = 0;
        for( ; start <= end; start++){
            chaiShu1[i] = shu[start];
            i++;
        }
        return chaiShu1;
    }

    //拆分的方法
    private static void chaiFen(int[] shu){
        if(shu.length > 2){
            //获取拆分的下标，此下标归为前面的数组
            int middleIndex = shu.length/2;
//            int[] chaiShu1 = new int[middleIndex+1];
//            int[] chaiShu2 = new int[shu.length-middleIndex];

            int[] chaiShu1 = createChaiShu(middleIndex+1, shu,0,middleIndex);
            chaiFen(chaiShu1);

            int[] chaiShu2 = createChaiShu(shu.length-middleIndex, shu,middleIndex,shu.length-1);
            chaiFen(chaiShu2);


        }else{
            //已经分到最小了，下面使用简单选择排序
            sort(shu);
        }
    }

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

    //简单选择排序
    public static void sort(int[] shu) {
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

    public static void main(String[] args) {
        int[] shu = new int[]{5,3,1,4,2};
        chaiFen(shu);
        print(shu);
    }


}
