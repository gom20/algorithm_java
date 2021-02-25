package tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11725 {

	public static ArrayList<Integer>[] tree = null;
	public static int[] parent= null;
	public static boolean[] visited = null;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		tree = new ArrayList[n+1];
		for(int i= 1; i < n+1; i++) {
			tree[i] = new ArrayList<Integer>();
		}
		for(int i = 0; i < n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}
		
		visited = new boolean[n+1];
		parent = new int[n+1];
		parent[1] = 1;
		
		dfs(1);

		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i =2; i <= n; i++) {
			bw.write(parent[i]+ "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(int x) {
		if(visited[x]) return;
		visited[x] = true;
		for(int child : tree[x]) {
			if(visited[child]) continue;
			parent[child] = x;
			dfs(child);
		}
	}
	
}
