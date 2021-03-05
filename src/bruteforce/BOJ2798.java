package bruteforce;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ2798 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		
		
		int[] nums = new int[t];		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < t; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int minDiff = Integer.MAX_VALUE;
		int sum = 0;
		for(int i = 0; i < t; i ++) {
			for(int j = 0; j < t; j++) {
				if(j==i) continue;
				for(int k = 0; k < t; k++) {
					if(k==i || k==j) continue;
					if(nums[i]+nums[j]+nums[k] > target) continue;
					int diff = target - (nums[i]+nums[j]+nums[k]);
					if(diff < minDiff) {
						minDiff = diff;
						sum = nums[i]+nums[j]+nums[k];
					}
				}
			}
		}
		
		bw.write(sum+"\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}
