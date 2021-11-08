package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2156 {

    public static void main(String[] args) throws Throwable{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1]; //dp[i] = i잔 까지 포도주가 있을 때, 지금까지 마신 포도주 양의 최대값
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = arr[1];
        if(N > 1) dp[2] = arr[1] + arr[2];
        for(int i = 3; i <= N; i++){
            // 1. i잔을 안마신다.
            dp[i] = dp[i-1];

            // 2. i잔을 한 번 연속으로 마신다.
            dp[i] = Math.max(dp[i], dp[i-2] + arr[i]);

            // 3. i잔을 두 번 연속으로 마신다.
            dp[i] = Math.max(dp[i], dp[i-3] + arr[i] + arr[i-1]);

        }
        System.out.println(dp[N]);
    }
}
