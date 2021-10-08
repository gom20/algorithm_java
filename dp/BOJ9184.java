package dp;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ9184 {
	static Integer dp[][][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = null;
		
		dp = new Integer[21][21][21];
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a==-1 && b ==-1 && c==-1) {
				break;
			}
			int result = w(a, b, c);
			bw.write("w("+a+", "+b+", "+c+") = ");
			bw.write(result+"\n");
			
		}
		
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int w(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		} else if(a > 20 || b > 20 || c > 20) {
			return get(20, 20, 20);
		} 
		
		if(a < b && b < c) {
			dp[a][b][c] = get(a, b, c-1) + get(a, b-1, c-1) - get(a, b-1, c);
		} else {
			dp[a][b][c] = get(a-1, b, c) + get(a-1, b-1, c) + get(a-1, b, c-1) - get(a-1, b-1, c-1);
		}					
		
		return dp[a][b][c];
		    
	}
	
	public static int get(int a, int b, int c) {
		if(dp[a][b][c] == null) {
			dp[a][b][c] = (int) w(a, b, c);
		}
		return dp[a][b][c];
	}
}

