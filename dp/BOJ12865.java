package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12865 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int capacity = Integer.parseInt(st.nextToken());
        int[] v = new int[n+1];
        int[] w = new int[n+1];
        int[][] dp = new int[n+1][capacity+1];

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= capacity; j++){
                if(w[i] > j ){
                    dp[i][j] = dp[i-1][j];
                    continue;
                }

                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + v[i]);
            }
        }

        System.out.println(dp[n][capacity]);

    }
}
