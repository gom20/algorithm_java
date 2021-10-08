package backtracking;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ14888 {
	public static int n;
	public static int nums[];
	public static int[] opers;
	public static int max = Integer.MIN_VALUE;
	public static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		
		// INPUT
		n = Integer.parseInt(br.readLine());
		nums = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		opers = new int[4];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			opers[i] = Integer.parseInt(st.nextToken());	
		}
		
		dfs(nums[0], 1);
		
		bw.write(max+"\n");
		bw.write(min+"\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	

	
	public static void dfs(int num, int idx) {
		if(idx == n) {
			if(num > max) {
				max = num;
			}
			if(num < min) {
				min = num;
			}
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int nextValue = num;
			if(opers[i] > 0) {				
				switch(i) {
				case 0: nextValue += nums[idx];
						opers[i]--;
						dfs(nextValue, idx+1);
						opers[i]++;
				break;
				case 1: nextValue -= nums[idx];
						opers[i]--;
						dfs(nextValue, idx+1);
						opers[i]++;
				break;
				case 2: nextValue *= nums[idx];
						opers[i]--;
						dfs(nextValue, idx+1);
						opers[i]++;
				break;
				case 3: nextValue /= nums[idx];
						opers[i]--;
						dfs(nextValue, idx+1);
						opers[i]++;
				break;
				}
			}
			
		}	
		
	}

}
