package sort;

/**
 * @author TF014268
 * @description 归并算法2
 * @since 2021/10/19 0019 17:04
 */
public class GuiBing2 {
    /*归：
        针对一个数据集进行排序
        对这个数据集  拆分成多个有序的数据集
        拆分到每个存储一个

    并：
        两个有序数组的排序
        准备两个有序数组
        创建一个新数组  长度=两个数组的长度和
        遍历两个旧数组  比较后  放入旧数组中

    原文链接：https://blog.csdn.net/qichangjian/article/details/87696735
    */

    /**
     * 递归拆分，直到一个数组只有一个元素
     * @param a  要排序的数组
     * @param low  开始下标
     * @param high  结束下标
     * @return
     */
    public static int[] sort(int[] a,int low,int high){
        int mid = (low+high)/2;
        if(low<high){
            //递归拆分前半部分
            sort(a,low,mid);
            //递归拆分后半部分
            sort(a,mid+1,high);
            //左右归并
            merge(a,low,mid,high);
        }
        return a;
    }

    /**
     * 合并左右两个数组（合并的过程中会排序）
     * @param a  要排序的数组
     * @param low  开始下标
     * @param mid  中间下标
     * @param high  结束下标
     */
    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high-low+1];
        int i= low;
        int j = mid+1;
        int k=0;
        // 把较小的数先移到新数组中
        while(i<=mid && j<=high){
            if(a[i]<a[j]){
                //此处k++  先赋值 后+1
                temp[k++] = a[i++];
            }else{
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while(i<=mid){
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while(j<=high){
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for(int x=0; x<temp.length; x++){
            a[x+low] = temp[x];
        }
    }

    //打印方法
    public static void print(int[] array){
        for(int a : array){
            System.out.print(a + "\t");
        }
    }

    public static void main(String[] args) {
        int[] shu = {2,4,3,6,1,5};
        sort(shu,0,shu.length-1);
        print(shu);
    }

}
