package lcs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ9252 {

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

        int max = dp[n][m];
        StringBuilder sb = new StringBuilder();
        int x = n;
        int y = m;
        while(true){
            if(s1.charAt(x-1) == s2.charAt(y-1)){
                sb.insert(0, s1.charAt(x-1));
                x = x-1;
                y = y-1;
            } else {
                if(dp[x][y] == dp[x-1][y]){
                    x = x-1;
                } else {
                    y = y-1;
                }
            }
            if(x == 0 || y == 0) break;
        }
        System.out.println(max);
        if(max > 0){
            System.out.println(sb.toString());
        }
    }
}
