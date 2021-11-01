package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11053 {

    public static int N;
    public static void pro() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        int totalMax = 0;
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(i == 1){
                dp[i] = 0;
                totalMax = 1;
                continue;
            }
            int max = 0;
            boolean exist = false;
            for(int j = 1; j < i ; j++){
                if(arr[i] > arr[j]){
                    exist = true;
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = exist? max+1 : 0; // i번째 수 왼편에 올 수 있는 바이토닉 부분 수열 원소의 최대 개수 (i번째 수는 미포함!)
            totalMax = Math.max(dp[i]+1, totalMax); // i번째 수를 포함시킨다.
        }

        System.out.println(totalMax);
    }

    public static void main(String[] args) throws Exception {
        pro();
    }
}
