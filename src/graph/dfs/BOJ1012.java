package graph.dfs;

import java.util.Scanner;

public class BOJ1012 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for(int t = 0; t < T; t ++) {
			int W = sc.nextInt();
			int H = sc.nextInt();
			int N = sc.nextInt();
			int[][] arr = new int[H][W];
			
			for(int j = 0; j < N; j++) {
				int x= sc.nextInt();
				int y = sc.nextInt();
				arr[y][x] = 1;
			}
			
			int cnt = 0;
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					if(arr[i][j] == 1) {					
						find(W, H, arr, i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
		
	}
	
	public static void find(int W, int H, int[][] arr, int i , int j) {
		if(i < 0 || i >= H|| j < 0 || j >= W) {
			return;
		}
		if(arr[i][j] == 1) {			
			arr[i][j] = -1;
			find(W, H, arr, i, j+1);
			find(W, H, arr, i, j-1);
			find(W, H, arr, i+1, j);
			find(W, H, arr, i-1, j);
		} 
		
	}

}
