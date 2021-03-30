package dp;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1003 {
	public static int[][] cnt;
	public static int zeroCnt1 = 0;
	public static int zeroCnt2 = 1;
	public static int oneCnt1 = 1;
	public static int oneCnt2 = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		cnt = new int[n][2];
		for(int i = 0; i < n; i++) {
			int zeroCnt1 = 0;
			int zeroCnt2 = 1;
			int oneCnt1 = 1;
			int oneCnt2 = 1;
			int num = Integer.parseInt(br.readLine());
			// #############################
			
			if(num == 0) {
				bw.write("1 0");
			}else if (num ==1) {
				bw.write("0 1");
			} else {
				
				for(int j = 3; j <= num; j++) {
					int tempZero = zeroCnt2;
					int tempOne  = oneCnt2;
					zeroCnt2 += zeroCnt1;
					zeroCnt1 = tempZero;
					oneCnt2 += oneCnt1;
					oneCnt1 = tempOne;
				}
				bw.write(zeroCnt2 + " " + oneCnt2);
			}
			bw.write("\n");
			
			// #############################
		}
		

		bw.flush();
		bw.close();
		br.close();
	}
	
	
}
