package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649 {

	
	public static String result = "";
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		boolean[] used = new boolean[n+1];
		for(int i = 1; i <= n; i++) {
			backtrack("", i, m, used.clone());
		}
	}
	
	public static void backtrack(String result, int x, int m, boolean[] used) {
		result += x;
		used[x] = true;
		if(result.length() == m) {
			for(char a : result.toCharArray()) {				
				System.out.print(a + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1 ; i < used.length; i ++) {
			if(!used[i]) {
				backtrack(result, i, m, used.clone());
			}
		}
				
	}
}
