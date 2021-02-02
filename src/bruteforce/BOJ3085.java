package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.acmicpc.net/problem/3085
public class BOJ3085 {

	static int n = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		char[][] arr = new char[n][n];
		for(int i = 0; i < n ; i++) {
			String line = br.readLine();
			for(int j = 0; j < n; j++) {
				arr[i][j] = line.charAt(j);
			}
		}
		
		int maxNum = 0;
		char temp;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {				
				temp = arr[i][j];
				if(i + 1 < n && arr[i][j] != arr[i+1][j]) {
					arr[i][j] = arr[i+1][j];
					arr[i+1][j] = temp;
					maxNum = findMaxNum(arr) > maxNum ? findMaxNum(arr) : maxNum;
					arr[i+1][j] = arr[i][j];
					arr[i][j] = temp;
				}
				
				temp = arr[i][j];
				if(j + 1 < n && arr[i][j] != arr[i][j+1]) {
					arr[i][j] = arr[i][j+1];
					arr[i][j+1] = temp;
					maxNum = findMaxNum(arr) > maxNum ? findMaxNum(arr) : maxNum;
					arr[i][j+1] = arr[i][j];
					arr[i][j] = temp;
				}
			}
		}
		System.out.println(maxNum);
	}
	

	public static int findMaxNum(char[][] arr) {
		int maxNum = 0;
		int num = 0;
		for(int i = 0; i < n; i ++ ) {
			for (int j = 0; j < n; j++) {
				num = findRow(arr, i, j, 1);
				maxNum = maxNum < num ? num : maxNum; 
				num = findColumn(arr, i, j, 1);
				maxNum = maxNum < num ? num : maxNum; 
			}
		}
		return maxNum;
	}
	
	public static int findRow(char[][] arr, int i, int j, int maxNum) {
		if(j + 1 < n && arr[i][j] == arr[i][j+1]) {
			maxNum++;
			maxNum = findRow(arr, i, j+1, maxNum);
		} 
		return maxNum;
	}
	
	public static int findColumn(char[][] arr, int i, int j, int maxNum) {
		if(i + 1 < n && arr[i][j] == arr[i+1][j]) {
			maxNum++;
			maxNum = findColumn(arr, i+1, j, maxNum);
		} 
		return maxNum;
	}
}
