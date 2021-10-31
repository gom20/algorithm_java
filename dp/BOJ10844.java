package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ10844 {

    public static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N+1][10];
        // dp[i][j] i는 자리수 j는 끝나는 숫자, 값은 i자리 수이면서 j로 끝나는 계단수 개수
        // dp[1][1~9] = 1개
        // dp[2][0] 10 : 1개
        // dp[2][1] 21 : 1개
        // dp[2][2] 12, 32 : 2개
        // ...
        // dp[1][8] 78, 98 : 2개
        // dp[2][9] 89 : 1개

        // dp[3][0]의 개수는? 2자리 수에서 0을 붙일 수 있는 숫자의 개수 dp[2][1]
        // dp[3][1]의 개수는? 2자리 수에서 1을 붙일 수 있는 숫자의 개수 dp[2][0] + dp[2][2]
        // dp[3][2] ? dp[2][1] + dp[2][3]
        // ...
        // dp[3][9]? dp[2][8]

        // 점화식 도출
        // j가 0이라면? dp[i][j] = dp[i-1][j+1]
        // j가 1~8이라면? dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1]
        // j가 9라면? dp[i][j] = dp[i-1][j-1]

        for(int i = 1; i <= N; i++){
            for(int j = 0; j <= 9; j++){
                if(i == 1 && j != 0){
                    dp[i][j] = 1;
                    continue;
                }
                if(j == 0){
                    dp[i][j] = dp[i-1][j+1]%1000000000;
                } else if(j == 9){
                    dp[i][j] = dp[i-1][j-1]%1000000000;
                } else {
                    dp[i][j] = dp[i-1][j-1]%1000000000 + dp[i-1][j+1]%1000000000;
                }
            }
        }

        long count = 0;
        for(int j = 0; j <= 9; j++){
            count += dp[N][j];
        }

        System.out.println(count%1000000000);
    }
}
