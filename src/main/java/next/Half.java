package next;

/**
 * @author TF014268
 * @description 折半查找
 * @since 2021/9/26 0026 17:05
 */
public class Half {

    /**
     *
     * @param start  开始下标
     * @param end  结束下标
     * @param shus  原数组
     * @param num  要查找的数字
     */
    public static void chaHalf(int start,int end,int[] shus,int num){
        if(num < shus[start] || num > shus[end]){
            System.out.println("数组中没有此数字");
            return;
        }

        System.out.println("查找一次------");

        //中间的下标
        int mid = (start+end) / 2;
        System.out.printf("开始的下标：%s，结束的下标：%s，中间下标：%s",start,end,mid);
        System.out.println();

        int midShu = shus[mid];
        System.out.println("中间的数为：" + midShu);

        if(midShu ==num){
            System.out.println("找到啦~~~~~~下标为" + mid);
        }else if(midShu >num){
            //中间数字  大于  要查找的数字，说明要查找的数字在前半段，所以需要把结束下标改变
            end = mid-1;
            chaHalf(start,end,shus,num);
        }else{
            //中间数字  小于  要查找的数字，说明要查找的数字在后半段，所以需要把开始下标改变
            start = mid+1;
            chaHalf(start,end,shus,num);
        }
    }

    public static void main(String[] args) {
        int[] shus = {1,22,33,41,57,60,72,88};
        int num = 88;
        chaHalf(0,shus.length-1,shus,num);
    }
}
