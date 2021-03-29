package backtracking;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ14889 {
	public static int n;
	public static int [] teamA;
	public static int [] teamB;
	public static int [] couple;
	public static int[][] arr;
	public static int totalScore;
	public static int score;
	public static int minDiff;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		teamA = new int[n/2];
		teamB = new int[n/2];
		couple = new int[2];
		minDiff = Integer.MAX_VALUE;
		
		StringTokenizer st = null;
		totalScore = 0;
		for(int i = 0; i <n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] =  Integer.parseInt(st.nextToken());
				totalScore += arr[i][j];
			}
		}
		
		dfs(0, 0);
		
		bw.write(minDiff+"");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(int count, int at) {
		// n/2¸í »Ì¾Æ¼­ teamA ¸¸µé±â
		if(count == n/2) {
			
			//teamB ¸¸µé±â
			boolean[] check = new boolean[n];
			for(int j = 0; j < n/2; j++) {
				for(int i = 0; i < n; i++) {	
					if(teamA[j] == i) {
						check[i] = true;
					}
				}
			}
			for(int j = 0; j < n/2; j++) {
				for(int i = 0; i < n; i++) {	
					if(!check[i]) {
						check[i] = true;
						teamB[j] = i;
						break;
					}
				}
			}
			
			
			score = 0;
			match(0, 0, teamA);
			int scoreA = score;
			score = 0;
			match(0, 0, teamB);
			int scoreB = score;
			if(Math.abs(scoreA-scoreB) < minDiff) {
				minDiff = Math.abs(scoreA-scoreB);
			}
//			System.out.println("-------------------------------");
			return;
		}
		
		for(int i = at; i < n; i++) {
			teamA[count] = i;
			dfs(count+1, i+1);
		}
	}
	
	public static void match(int count, int at, int[] team) {
		// n/2¸í¿¡¼­ ½Ö Áþ±â
		if(count == 2) {
//			for(int idx : couple) {
//				System.out.print(idx + " ");
//			}
			
			score += arr[couple[0]][couple[1]];
			score += arr[couple[1]][couple[0]];
			
//			System.out.println("");
			return;
		}
		
		for(int i = at; i < n/2; i++) {
			couple[count] = team[i];
			match(count+1, i+1, team);
		}
	}
	
	
}
