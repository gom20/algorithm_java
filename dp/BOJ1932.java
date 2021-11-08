package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1932 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][N+1];
        StringTokenizer st = null;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= i; j++){
                dp[i][j] = Integer.parseInt(st.nextToken());
                if(i == 1 && j == 1) continue;
                if(j == 1){
                    dp[i][j] += dp[i-1][j];
                } else if(j == i){
                    dp[i][j] += dp[i-1][j-1];
                } else {
                    dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]);
                }
                if(i == N){
                    answer = Math.max(dp[i][j], answer);
                }
            }
        }
        if(N == 1){
            System.out.println(dp[1][1]);
        } else {
            System.out.println(answer);
        }
    }
}
