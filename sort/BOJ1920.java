package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n+1];
		for(int i = 1; i < n+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] tArr = new int[m];
		for(int i = 0; i < m; i++) {
			tArr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < m; i++) {
			int num = tArr[i];
			
			System.out.println(find(num, arr, 1, n));	
		}		
	}
	
	public static int find(int num, int[] arr, int sIdx, int eIdx) {
		if(eIdx-sIdx == 1) {
			if(arr[eIdx] == num || arr[sIdx] == num) {
				return 1;
			} else {
				return 0;
			}
		}
		int midIdx = (eIdx+sIdx)/2;
		if(arr[midIdx] > num) {
			return find(num, arr, sIdx, midIdx);
		} else if(arr[midIdx] < num) {
			return find(num, arr, midIdx, eIdx);
		} else {
			return 1;
		}
		
	}
}


