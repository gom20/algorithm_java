package dp;

import java.util.Scanner;

public class BOJ12852 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int dp[] = new int[n+1];
        for(int i = 2; i <= n; i++){
            if(i == 2 || i == 3){
                dp[i] = 1;
                continue;
            }
            int min = dp[i-1]+1;
            if(i%3 == 0) min = Math.min(min, dp[i/3]+1);
            if(i%2 == 0) min = Math.min(min, dp[i/2]+1);

            dp[i] = min;
        }

        System.out.println(dp[n]);

        StringBuilder sb = new StringBuilder();
        sb.append(n).append(" ");
        while(n > 1){

            int min = dp[n-1];
            int ans = n-1;
            if(n%3 == 0 && dp[n/3] < min){
                min = dp[n/3];
                ans = n/3;
            }
            if(n%2 == 0 && dp[n/2] < min){
                min = dp[n/2];
                ans = n/2;
            }
            n = ans;
            sb.append(n).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
