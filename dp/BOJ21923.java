package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21923 {

    public static int N, M;
    public static int[][] arr;
    public static int[][] up;
    public static int[][] down;

    public static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        up = new int[N+1][M+1];
        down = new int[N+1][M+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                int num =Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                up[i][j] = num;
                down[i][j] = num;
            }
        }
    }

    public static void init(){
        for(int i = N-1; i >= 1; i--){
            up[i][1] = up[i][1] + up[i+1][1];
        }
        for(int i = 2; i <= M; i++){
            up[N][i] = up[N][i] + up[N][i-1];
        }

        for(int i = N-1; i >= 1; i--){
            down[i][M] = down[i][M] + down[i+1][M];
        }
        for(int i = M-1; i >= 1; i--){
            down[N][i] = down[N][i] + down[N][i+1];
        }
    }

    public static void main(String[] args) throws Exception{
        input();
        init();

        for(int i = N-1; i >=1; i--){
            for(int j = 2; j <= M; j++){
                up[i][j] = up[i][j] + Math.max(up[i][j-1], up[i+1][j]);
            }
        }

        for(int i = N-1; i >=1; i--){
            for(int j = M-1; j >= 1; j--){
                down[i][j] = down[i][j] + Math.max(down[i][j+1], down[i+1][j]);
            }
        }

        // max 찾기
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                max = Math.max(down[i][j] + up[i][j], max);
            }
        }

        System.out.println(max);

        // test print
//        for(int i = 1; i <= N; i++){
//            System.out.println("");
//            for(int j = 1; j <= M; j++){
//                System.out.print(up[i][j] + " ");
//            }
//        }
//        System.out.println("");
//        for(int i = 1; i <= N; i++){
//            System.out.println("");
//            for(int j = 1; j <= M; j++){
//                System.out.print(down[i][j] + " ");
//            }
//        }
        // test print end

    }

}
