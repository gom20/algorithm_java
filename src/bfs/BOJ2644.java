package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2644 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int pCnt = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int pA = Integer.parseInt(st.nextToken());
		int pB = Integer.parseInt(st.nextToken());
		
		int rCnt = Integer.parseInt(br.readLine());
		boolean[][] rArr = new boolean[pCnt+1][pCnt+1];
		for(int i = 0; i < rCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			rArr[x][y] = true;
			rArr[y][x] = true;
			
		}
		
		boolean[] visited  = new boolean[pCnt+1];
		Queue<Integer> Q = new LinkedList<Integer>();
		
		Q.add(pA);
		visited[pA] = true;
		int level = 0;
		boolean isExist = false;
		
		Loop: while(!Q.isEmpty()) {
			int qSize = Q.size();
			for(int k = 0; k < qSize; k++) {
				int node = Q.poll();
				for(int i = 1; i < pCnt+1; i++) {
					if(!visited[i] && rArr[node][i]) {
						visited[i] = true;
						Q.add(i);
						if(i == pB) {
							isExist = true;
							level++;
							break Loop;
						}
					}
				}
			}
			
			if(!Q.isEmpty()) {				
				level ++;
			}
		}
		
		if(isExist) {			
			System.out.println(level);
		} else {
			System.out.println(-1);
		}
		
	}
}
