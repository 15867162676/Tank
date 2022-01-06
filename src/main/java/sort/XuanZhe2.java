package sort;

/**
 * @author TF014268
 * @description 简单选择排序2
 * @since 2021/10/14 0014 14:00
 */
public class XuanZhe2 {

    /**
     * 交换位置的方法
     * @param elem
     * @param i
     * @param j
     */
    public void swap(int[] elem, int i, int j) {
        int temp = elem[i];
        elem[i] = elem[j];
        elem[j] = temp;
    }

    //简单选择排序
    public void selectSort(int[] elem) {
        int min;
        for (int i = 1; i < elem.length; i++) {
            //设定第i位置上的数是最小的
            min = i;
            //然后逐个与后面的数字比较，如果有更小的就交换位置
            for (int j = i+1; j < elem.length; j++) {
                if(elem[min] > elem[j]) {
                    min = j;
                }
            }

            //最小值的下标和原来的不一样了，交换位置
            if(min != i) {
                swap(elem, i, min);
            }
        }
    }

    public static void main(String[] args) {
        XuanZhe2 s = new XuanZhe2();
        int[] elem = {0, 9, 1, 5, 8, 3, 7, 4, 6, 2};
        s.selectSort(elem);
        for (int i = 0; i < elem.length; i++) {
            System.out.print(elem[i] + ", ");
        }
    }
}
