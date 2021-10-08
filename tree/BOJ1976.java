package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1976 {
	
	public static int parent[];
	public static int level[];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		level = new int[n+1];
		parent = new int[n+1];
		for(int i = 1; i < n+1; i++) {			
			level[i] = 0;
			parent[i] = i;
		}
		
		StringTokenizer st = null;
		for(int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < n+1; j++) {
				int x = Integer.parseInt(st.nextToken());
				if(x == 1) {
					merge(i, j);
				}
			}
		}


		boolean check = true;
		st = new StringTokenizer(br.readLine());
		int root = find(Integer.parseInt(st.nextToken()));
		for(int i = 0; i < m-1; i++) {
			if(find(Integer.parseInt(st.nextToken())) != root) {
				check = false;
			}
		}
		
		if(check) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
		
	}
	
	public static void merge(int i, int j) {
		int rootI = find(i);
		int rootJ = find(j);
		
		if(rootI == rootJ) return;
		
		if(level[rootI] < level[rootJ]) {
			parent[rootI] = rootJ;
		} else {
			parent[rootJ] = rootI;
			
			if(level[rootI] == level[rootJ]) {
				level[rootI] += 1;
			}
		}
		
	}
	
	public static int find(int i) {
		if(parent[i] == i) return i;
		return parent[i] = find(parent[i]);
	}
		
}
