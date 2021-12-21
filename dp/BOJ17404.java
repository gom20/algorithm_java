package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17404 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][3];
        int[][] cost = new int[N+1][3];
        StringTokenizer st = null;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        int INF = 1000*1000 + 1;
        int answer = INF;
        for(int c = 0; c < 3; c++){
            for(int i = 0; i < 3; i++){
                if(i == c) dp[1][i] = cost[1][i];
                else dp[1][i] = INF;
            }

            for(int i = 2; i <= N; i++){
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
            }

            for(int i = 0; i < 3; i++){
                if(i != c) answer = Math.min(answer, dp[N][i]);
            }
        }
        System.out.println(answer);
    }
}
