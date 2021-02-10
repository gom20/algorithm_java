package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2606 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int totalN = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		boolean[] visited = new boolean[totalN+1];
		boolean[][] adjEdges = new boolean[totalN+1][totalN+1];
		for(int i = 0; i < N; i++) {			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adjEdges[x][y] = true;
			adjEdges[y][x] = true;
		}
		
		bfs(1, adjEdges, visited);
	}
	
	public static void bfs(int node, boolean[][] adjEdges, boolean[] visited) {
		int cnt = 0;
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(node);
		visited[node] = true;

		while(!queue.isEmpty()) {
			int cNode = queue.poll();

			for(int i = 0; i < adjEdges.length; i++) {
				if(!visited[i] && adjEdges[cNode][i]) {
					cnt++;
					visited[i] = true;
					queue.add(i);
				}
			}
		}
		
		System.out.println(cnt);
		
	}
	
}
