package next;

/**
 * @author TF014268
 * @description 顺序查找
 * @since 2021/9/26 0026 16:52
 */
public class ShunXu {

    public static void cha(int[] shus,int num){
        for(int i=0;i<shus.length;i++){
            System.out.println("第" + (i+1) + "次查找");
            if(shus[i]==num){
                System.out.println("找到啦~~~~~~~");
                return;
            }
        }
        System.out.println("没有找到此数字");
    }

    public static void main(String[] args) {
        int[] shus = {1,7,3,5,2,6,8,9,4};
        int num = 5;
        cha(shus,num);
    }
}
