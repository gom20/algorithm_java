package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1992 {

    public static int oneCnt, zeroCnt;
    public static int[][] arr;
    public static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        oneCnt = 0;
        zeroCnt = 0;
        sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            String s = br.readLine();
            for(int j = 1; j <= N; j++){
                arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j-1)));
            }
        }

        divide(1, 1, N);
        System.out.println(sb.toString());
    }

    private static void divide(int x, int y, int N){
        int cnt = 0;
        for(int i = x;  i < x+N; i++ ){
            for(int j = y; j < y+N; j++){
                if(arr[i][j] == 1){
                    cnt++;
                }
            }
        }
        if(cnt == N*N){
            sb.append(1);
        } else if(cnt == 0){
            sb.append(0);
        } else {
            sb.append("(");
            divide(x, y, N/2); // up-left
            divide(x,y+N/2, N/2); // up-right
            divide(x+N/2, y, N/2); // down-left
            divide(x+N/2, y+N/2, N/2); //down-right
            sb.append(")");
        }

    }
}
