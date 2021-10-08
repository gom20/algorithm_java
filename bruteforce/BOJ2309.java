package bruteforce;
//https://www.acmicpc.net/problem/2309

import java.util.Arrays;
import java.util.Scanner;

public class BOJ2309 {
	public static void main(String[] args) {
		
		int[] arr = new int[9];
		int total = 0;
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
			total += arr[i];
		}
		
		loop: for(int i = 0; i < 9; i++) {
			total -= arr[i];
			for(int j = 0; j < 9; j++) {
				if(j == i) continue;
				total -= arr[j];
				if(total == 100) {
					arr[i] = 0;
					arr[j] = 0;
					break loop;
				} 
				total += arr[j];
			}
			total += arr[i];
		}
		
		Arrays.sort(arr);
		for(int i = 2; i < 9; i++) {
			System.out.println(arr[i]);
		}		
	}
}
