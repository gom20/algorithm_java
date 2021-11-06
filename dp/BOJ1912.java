package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1912 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        int[] dp = new int[N];

        // dp[i] = i번째 수를 포함하는 연속합의 최대값
        // dp[i] = dp[i-1] + i번째 수
        // 만약 dp[i-1]가 음수일 경우는 i번째 수부터 시작

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            if(i == 0){
                dp[i] = Integer.parseInt(st.nextToken());
            } else {
                dp[i] = (dp[i-1] > 0 ? dp[i-1] : 0) + Integer.parseInt(st.nextToken());
            }
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}
