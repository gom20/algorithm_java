package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][3];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for( int j =0; j< 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}	
		}
		
		for(int i = 0; i < N; i++) {
			if(i != 0) {
				arr[i][0] += min(arr[i-1][1], arr[i-1][2]);
				arr[i][1] += min(arr[i-1][0], arr[i-1][2]);
				arr[i][2] += min(arr[i-1][0], arr[i-1][1]);
			}
		}

		
		int result = min(min(arr[N-1][0], arr[N-1][1]), arr[N-1][2]);
		System.out.println(result);

	}

	

	public static int min(int a, int b) {
		return a > b ? b : a;
	}
}

