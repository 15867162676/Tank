package sort;

/**
 * @author TF014268
 * @description 快速排序
 * @since 2021/10/26 0026 15:54
 */
public class KuaiSu {

    /**
     *
     * @param R  要排序的数组
     * @param lo  低位值的下标
     * @param hi  高位置的下标
     */
    static void QuickSort(int R[], int lo, int hi){
        int i = lo, j = hi;

        if(i>=j){
            return;
        }

        int temp = R[i];
        while (i != j){
            //从下标j的和关键字进行比较。如果j上的数比较大，j向前一位，继续比较
            while(j > i && R[j] > temp){
                -- j;
            }
            R[i] = R[j];

            //从下标i的和关键字进行比较。如果i上的数字小，i向后一位，继续比较
            while(i < j && R[i] < temp){
                ++ i;
            }
            R[j] = R[i];
        }
        R[i] = temp;

        //以下标i为界限，分成两段进行处理
        QuickSort(R, lo, i - 1);
        QuickSort(R, i + 1, hi);
    }

    //打印方法
    public static void print(int[] array){
        for(int a : array){
            System.out.print(a + "\t");
        }
    }

    public static void main(String[] args) {
        int[] shu = {2,4,3,6,1,5};
        QuickSort(shu,0,shu.length-1);
        print(shu);
    }

}
