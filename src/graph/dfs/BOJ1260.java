package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {

	public static boolean[][] adjEdge;
	public static boolean[] visited;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int nodeCnt = Integer.parseInt(st.nextToken());
		int edgeCnt = Integer.parseInt(st.nextToken());
		int startNode = Integer.parseInt(st.nextToken());
		
		visited = new boolean[nodeCnt+1];
		adjEdge = new boolean[nodeCnt+1][nodeCnt+1];
		
		for(int i = 0; i < edgeCnt; i ++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			adjEdge[node1][node2] = true;
			adjEdge[node2][node1] = true;
		}
		
		dfs(startNode);
		
		System.out.println("");
		visited = new boolean[nodeCnt+1];
		
		bfs(startNode);
		
	}
	
	public static void dfs(int node) {
		System.out.print(node + " ");
		visited[node] = true;
		
		for(int i = 1; i < adjEdge.length; i ++) {			
			if(adjEdge[node][i] && !visited[i]) {
				dfs(i);
			}	
		}
	}
	
	public static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(node);
		
		while(!queue.isEmpty()) {
			int targetNode = queue.poll();
			visited[targetNode] = true;
			System.out.print(targetNode + " ");
			
			for(int i = 1; i < adjEdge.length; i ++) {			
				if(adjEdge[targetNode][i] && !visited[i] && !queue.contains(i)) {
					queue.offer(i);
				}	
			}
		}
		
	};
}
