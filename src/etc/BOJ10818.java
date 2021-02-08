package etc;

import java.util.Scanner;

public class BOJ10818 {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int max = -1000001;
		int min = 1000001;
		for(int i = 0; i < N; i++) {
			int M = sc.nextInt();
			if(max < M) max = M;
			if(min > M) min = M;
		}
		
		System.out.println(min + " " + max);
	}
}
