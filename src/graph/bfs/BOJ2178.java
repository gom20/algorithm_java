package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2178 {

	public static int H;
	public static int W;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		H = Integer.parseInt(str[0]);
		W = Integer.parseInt(str[1]);
		
		int[][] arr = new int[H][W];
		for(int i = 0 ; i < H ; i++) {
			str = br.readLine().split("");
			for(int j = 0; j < W; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
			
		dfs(arr, 0, 0);
		
	}
	
	public static void dfs(int[][] arr, int i, int j) {
		int level = 1;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[]{i, j});
		
		loop: while(!queue.isEmpty()) {
			
			int qSize = queue.size();
			
			for(int k = 0; k < qSize; k++) {				
				int[] xy = queue.poll();
				int x = xy[0];
				int y = xy[1];
						
				if(x < H && y < W && x >= 0 && y >= 0 && arr[x][y] == 1) {
//					System.out.println(x + ", " + y);
					if(x == H-1 && y == W-1) {
						System.out.println(level);
						break loop;
					}
					arr[x][y]= -1; // visited
					queue.add(new int[]{x, y+1});
					queue.add(new int[]{x, y-1});
					queue.add(new int[]{x+1, y});
					queue.add(new int[]{x-1, y});	
				};
			}
			
			level++;
					
		}
		
	}
}
