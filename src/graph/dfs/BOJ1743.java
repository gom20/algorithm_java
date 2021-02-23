package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1743 {

	public static int cnt;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[H+1][W+1];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
		}
		
		int maxCnt = 0;
		for(int i = 1; i <= H; i++) {
			for(int j = 1; j <= W; j++) {
				cnt = 0;
				find(arr, i, j);
				maxCnt = maxCnt < cnt ? cnt : maxCnt;
			}
		}
		
		System.out.println(maxCnt);
	}
	
	public static void find(int[][] arr, int i, int j) {
		if(i < 0 || i >= arr.length || j < 0 || j >= arr[i].length ) return;
		if(arr[i][j] != 1) return; 
		arr[i][j] = -1;
		cnt++;
		find(arr, i-1, j);
		find(arr, i+1, j);
		find(arr, i, j-1);
		find(arr, i, j+1);
	}
}
