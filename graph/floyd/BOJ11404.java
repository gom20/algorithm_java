package graph.floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11404 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());
		
		
		long[][] arr = new long[n+1][n+1];
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < n+1; j++) {
				if(i==j) {
					arr[i][j] = 0;
				} else {
					arr[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		
		StringTokenizer st = null;
		for(int i = 0; i < e; i++) {			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			if(arr[a][b] != 0) {
				arr[a][b] = min(arr[a][b], dist);
			}
			
		}
		
		
		for(int layover = 1; layover < n+1; layover++) {
			for(int start = 1; start < n+1; start++) {
				for(int end = 1; end < n+1; end++) {
					arr[start][end] = min(arr[start][end], arr[start][layover]+arr[layover][end]);
				}
			}
		}
		
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < n+1; j++) {
				if(arr[i][j] >= Integer.MAX_VALUE) {					
					System.out.print("0 ");
				} else {
					System.out.print(arr[i][j] + " ");
				}
			}
			System.out.println();
		}
		
	}
	
	public static long min(long a, long b) {
		return a > b ? b: a;
	}
}
