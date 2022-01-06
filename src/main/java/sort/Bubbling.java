package sort;

/**
 * @author TF014268
 * @description 冒泡排序法
 * @since 2021/9/24 0024 14:18
 */
public class Bubbling {

    //升序排列--从第一个元素开始排序
    public static void sort(int[] array){
        if(null==array || array.length<=0){
            return;
        }

        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-1-i;j++){
                //前面的  比  后面的  大
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
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
