package stack;

import java.util.Scanner;
import java.util.Stack;

public class BOJ1725 {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt() + 1;
		int[] arr = new int[N];
		for(int i = 0; i < N ; i++) {
			if(i == N-1) {
				arr[i] = 0;
			} else {		
				arr[i] = sc.nextInt();
			}
		}

		
		Stack<Integer> st = new Stack<Integer>();
		int max = 0;
		for(int i = 0; i < N; i ++) {
			int next = arr[i];
			if(i == 0) {				
				st.push(i);
			} else {
				if(next >= arr[st.peek()]) {
					st.push(i);
				} else {
					while(!st.isEmpty() && arr[st.peek()] > next) {
						int height = arr[st.peek()];
						int right = i-1;
						st.pop();
						int left;
						if(st.empty()) {
							left = 0;
						} else {
							left = st.peek() + 1;
						}
						
						int width = right - left + 1;
						max = max > height * width ? max: height * width;
						

					}
					st.push(i);
				}
				
			}
		}
		
		
		System.out.println(max);
	}
}
