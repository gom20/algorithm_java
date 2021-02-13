package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ11000 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][2];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				int result  = 0;
				if(Integer.compare(o1[0], o2[0]) == 0) {
					result = Integer.compare(o1[1], o2[1]);
				} else {
					result = Integer.compare(o1[0], o2[0]);
				}
				return result;
			}
		});
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		
		for(int i = 0 ; i < N; i++) {
			if(i == 0) {				
				queue.add(arr[i][1]);
			} else {
				if(!queue.isEmpty()) {
					if(queue.peek() <= arr[i][0]) {
						queue.poll();
						queue.add(arr[i][1]);
					} else {
						queue.add(arr[i][1]);
					}
				}
		
			}
			
		}
		
		System.out.println(queue.size());
	}
}
