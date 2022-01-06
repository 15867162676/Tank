package RuanKao.rk201905;

/**
 * @author TF014268
 * @description N皇后问题
 * @since 2021/10/13 0013 19:14
 */
public class N_huangHou2 {
    /*
    *  0 1 2 3 4
    *  0 1 2 3 4
    *  0 1 2 3 4
    *  0 1 2 3 4
    * */

    //n个皇后
    static int n = 4;
    //皇后所在的列的数组（从下标1开始）
    static int[] queen = new int[n+1];

    //摆放皇后位置的方法  当皇后先摆在第j行上的位置时
    public static void Nqueen(int j){
        int i;
        //此方法每迭代一次，都会摆放好第j行上的皇后
        for(i=1;i<=n;i++){
            //循环判断  皇后位置放在第j行的第i列 上行不行
            queen[j] = i;
            if(place(j)==1 && j<=n){
                //第j行的第i列上放皇后满足条件  且 还没有超过最后一行
                if(j==n){
                    //如果所有的皇后都摆放好了，则输出摆放方案
                    show();
                }else{
                    //继续摆放下一行的皇后
                    Nqueen(j+1);
                }
            }
        }
    }

    //检查当前列是否能摆放皇后，不能放返回0，能放返回1
    private static int place(int j) {
        for(int i=1;i<j;i++){
            //判断  同一列上  或  同一斜线  是否有皇后
            if(queen[i]==queen[j]
                    || Math.abs(queen[i]-queen[j])==(Math.abs(j-i))){
                return 0;
            }
        }
        return 1;
    }

    //输出皇后的位置
    public static void show(){
        System.out.print("(");
        for(int i=0;i<=n;i++){
            System.out.printf("%d",queen[i]);
        }
        System.out.print(")");
    }

    public static void main(String[] args) {
        Nqueen(1);
    }
}
