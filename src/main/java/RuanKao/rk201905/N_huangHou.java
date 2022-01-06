package RuanKao.rk201905;

/**
 * @author TF014268
 * @description N皇后问题
 * @since 2021/10/13 0013 19:14
 */
public class N_huangHou {
    //判断是否是在同一列或同一条斜线上
    //不能放返回0，能放返回1
    public void Place(int j,int[] lie){
        for(int i=1;i<=lie.length;i++){

        }
    }

    //摆放皇后，n为皇后的个数
    public void baiFang(int n){
        //数组下标为皇后所在的行（从1开始），下标对应的值为皇后所在的列
        int[] lie = new int[n+1];
        int i = 1;
        for(;i<=n;i++){
            for(int j=1;j<=4;j++){
                lie[i] = j;

            }

        }

    }
}
