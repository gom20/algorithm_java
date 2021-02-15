package dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ2667 {
	
	public static int cnt = 0; 

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[][] arr = new int[N][N];
		
		
		for(int i = 0; i < N; i++ ) {
			String val = sc.next();
			char[] cArr = val.toCharArray();
					
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.valueOf(String.valueOf(cArr[j]));
			}
		}
		
		ArrayList<Integer> cntArr = new ArrayList<Integer>();
		int clusterCnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j] == 1) {
					cnt = 0;
					clusterCnt++;
					find(arr, i, j);
					cntArr.add(cnt);
				}
			}
		}
		
		Collections.sort(cntArr);
		System.out.println(clusterCnt);
		for(int cnt : cntArr) {			
			System.out.println(cnt);
		}
		
	}
	
	public static void find(int [][] arr, int i, int j) {
		if(i < 0 || j < 0 || i >= arr.length || j >= arr.length || arr[i][j] != 1) return ;
		arr[i][j] = -1;
		cnt++;
		
		find(arr, i-1, j);
		find(arr, i+1, j);
		find(arr, i, j-1);
		find(arr, i, j+1);
	}
}
