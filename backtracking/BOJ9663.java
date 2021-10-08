package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9663 {

	public static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
	
		dfs(n);
		
		System.out.println(count);
		
	}
	
	public static void dfs(int n) {
		int[] arr = new int[n];
		dfs(0, arr);
	}
	
	public static void dfs(int n, int[] arr) {
		if(n == arr.length) {
			count++;
		} else {			
			for(int i = 0; i < arr.length; i++) {
				arr[n] = i;
				if(isPromissing(n, arr)) {
					dfs(n+1, arr);
				}
			}
		}
		
	}
	
	public static boolean isPromissing(int n, int[] arr) {
		for(int i = 0 ; i < n; i++) {
			if(arr[i] == arr[n]) return false;
			if(arr[i] - arr[n] == n-i) return false;
			if(arr[n] - arr[i] == n-i) return false;
		}
		
		return true;
	}
}
