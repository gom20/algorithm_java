package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ9465 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++ ) {
			int N =	Integer.parseInt(br.readLine());
			
			int[][] arr = new int[3][N+1]; 
			for(int i = 1; i < 3; i++ ) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 1; j < N+1; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int j = 1; j < N+1; j++) {
				for(int i = 1; i < 2; i++) {
					arr[i][j] = arr[i-1][j-1] > arr[i+1][j-1] ? arr[i][j] + arr[i-1][j-1]: arr[i][j] + arr[i+1][j-1];
					arr[i+1][j] = arr[i-1][j-1] > arr[i][j-1] ? arr[i+1][j] + arr[i-1][j-1]: arr[i+1][j] + arr[i][j-1];
					if(j < N) {
						arr[i-1][j+1]= arr[i][j] > arr[i+1][j] ? arr[i][j] : arr[i+1][j];
					}
				}
			}
			System.out.println(arr[1][N] > arr[2][N] ? arr[1][N] : arr[2][N]);
		}
	}	
}
