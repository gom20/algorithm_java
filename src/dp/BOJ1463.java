package dp;

import java.util.Scanner;

public class BOJ1463 {
	
	static int[] dp;
	static int temp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		dp = new int[1000001];
		System.out.println(f(num));
	}

	
	public static int f(int num) {
		if(num == 1) return 0;
		if(dp[num] != 0) return dp[num];
		
		int result = f(num-1) + 1;	
		if(num%3 == 0) {
			temp = f(num/3) + 1 ;
			result = result < temp ? result : temp;
		}
		if(num%2 == 0) {
			temp = f(num/2) + 1 ;
			result = result < temp ? result : temp;
		}
	
		dp[num] = result;	
		return result;
	}
}
