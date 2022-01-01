package floyd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ10159 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int map[][] = new int[N+1][N+1];
		
		StringTokenizer st = null;
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// a > b
			map[a][b] = 1;
			map[b][a] = -1;
		}
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(map[i][k] == 1 && map[k][j] == 1) {
						map[i][j] = 1;
						map[j][i] = -1;
					}
					if(map[i][k] == -1 && map[k][j] == -1) {
						map[i][j] = -1;
						map[j][i] = 1;
					}
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			int cnt = 0;
			for(int j = 1; j <= N; j++) {
				if(i == j) continue;
				if(map[i][j] == 0) cnt++;
			}
			System.out.println(cnt);
		}	
	}
}
