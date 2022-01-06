package sort;

/**
 * @author TF014268
 * @description 插入排序
 * @since 2021/9/24 0024 17:21
 */
public class InsertSort {

    //升序
    public static void sort(int[] array){
        if(null==array || array.length<=0){
            return;
        }

        for(int i=1;i<array.length;i++){
            int j = i;
            //内部循环退出条件
            while (j > 0){
                //比前一个小，与前一个交换位置，j--，继续比较
                if (array[j] < array[j-1]){
                    int temp ;
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                    j--;
                }else{
                    //已经找到插入的位置了，直接退出内部循环
                    break;
                }
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
        int[] shu = {2,5,1,3,4};
        sort(shu);
        print(shu);

    }
}
