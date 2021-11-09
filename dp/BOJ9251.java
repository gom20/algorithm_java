package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ9251 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
               if(i == 0 || j == 0){
                   dp[i][j] = 0;
                   continue;
               }
               if(s1.charAt(i-1) == s2.charAt(j-1)){
                   dp[i][j] = dp[i-1][j-1] + 1;
               } else {
                   dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
               }
            }
        }

        System.out.println(dp[n][m]);

    }
}
