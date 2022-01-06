package RuanKao.rk202105.t4;

/**
 * @author TF014268
 * @description 凸多边形分割
 * @since 2021/9/10 0010 9:33
 */
public class DuoBianXing {
    //六边形
    static int N = 6;

    //m[i][j]表示多边形Vi-1 到 Vj最优三角剖分的权值
    int[][] m = new int[N+1][N+1];

    //S[][]记录多边形Vi-1到Vj最优三角剖分的k值
    int[][] S = new int[N+1][N+1];

    //凸多边形的权重矩阵
    int[][] W = new int[N+1][N+1];

    //三角形的权重abc,三角形的顶点下标
    int getTriangleWeight(int a,int b,int c){
        return W[a][b] + W[b][c] + W[c][a];
    }

    //求解最优值
    void trianglePartition(){
        int i,r,k,j;
        int temp;
        //初始化
//        for(i=1;i<=N;i++){
//            m[i][j] = 0;
//        }
    }
}
