package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2294 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sc = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(sc.nextToken());
		int K = Integer.parseInt(sc.nextToken());
		
		int[] coin = new int[N];
		for(int i = 0; i < N; i ++) {
			coin[i] = Integer.parseInt(br.readLine());	
		}
		
		int[] dp = new int[K+1];
		for(int i = 0; i < K+1; i++) {
			dp[i] = 100001;
		}
		
		for(int i = 1; i < K+1; i++) {
			for(int j = 0; j < N; j++) {
				if(coin[j] == i) {
					dp[i] = 1;
				} else if(i-coin[j] >= 0) {
					dp[i] = min(dp[i], dp[i-coin[j]]+1); 
				}
			}
		}
		if(dp[K] == 100001) {
			System.out.println(-1);
		} else {
			System.out.println(dp[K]);
		}
		
	}
	
	public static int min(int a, int b) {
		return a < b ? a : b;
	}
}


