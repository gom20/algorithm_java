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

	public static class BOJ2178 {

		public static int[][] arr;
		public static int N, M;
		public static int[][] dist, adjs;
		public static Queue<int[]> que;

		public static void input() throws Exception{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			que = new LinkedList<int[]>();
			dist = new int[N][M];
			arr = new int[N][M];
			adjs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
			for(int i = 0; i < N; i++){
				arr[i] = toIntArray(br.readLine().toCharArray());
			}
		}

		public static int[] toIntArray(char[] arr){
			int[] result = new int[arr.length];
			for(int i = 0; i < arr.length; i++){
				result[i] = Integer.parseInt(String.valueOf(arr[i]));
			}
			return result;
		}

		public static boolean isValid(int x, int y){
			if(x < 0 || x >= N || y < 0 || y >= M) return false;
			if(arr[x][y] == 0 || arr[x][y] == -1) return false;
			return true;
		}

		public static void bfs(){
			dist[0][0] = 1;
			arr[0][0] = -1; // visited

			que.add(new int[]{0, 0});

			while(!que.isEmpty()){
				int[] elem = que.poll();
				int x = elem[0];
				int y = elem[1];
				int curDist = dist[x][y];

				for(int[] adj : adjs){
					int newX = x + adj[0];
					int newY = y + adj[1];

					if(isValid(newX, newY)){
						dist[newX][newY] = curDist + 1;
						arr[newX][newY] = -1;
						que.offer(new int[]{newX, newY});
					}
				}
			}

		}


		public static void main(String[] args) throws Exception{
			input();
			bfs();
			System.out.println(dist[N-1][M-1]);
		}

	}
}
