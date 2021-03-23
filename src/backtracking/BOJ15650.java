package backtracking;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ15650 {
	public static int n;
	public static int m;
	public static BufferedWriter bw;
	public static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[m];
		
		dfs(1, 0);
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(int at, int depth) throws IOException {
		if(depth == m) {
			for(int i = 0; i < arr.length; i++) {
				if(i == arr.length-1) {
					bw.write(arr[i]+"\n");
				} else {
					bw.write(arr[i]+" ");
				}
			}
			return;
		}
		
		for(int i = at; i <= n; i++) {
			arr[depth] = i; 
			dfs(i+1, depth+1);
		}
	}
	
}
