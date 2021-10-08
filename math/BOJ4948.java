package math;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ4948 {
	
	public static boolean notPrimeNums[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		setPrimeNums();
		
		while(true){
			int n = Integer.parseInt(br.readLine());
			if(n == 0) break;
			bw.write(getPrimeNumCnt(n)+"\n");
		
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void setPrimeNums() {
		int n = 123456*2;
		notPrimeNums = new boolean[n+1];
		for(int i = 1; i < n/2; i++) {
			if(i == 1) {
				notPrimeNums[i] = true;
				continue;
			}
			
			for(int j = i+i; j <= n; j= j+i) {
				notPrimeNums[j] = true;
			}
		}
	}
	
	public static int getPrimeNumCnt(int n) {
		int cnt = 0;
		for(int i = n+1; i <= 2*n; i++) {
			if(!notPrimeNums[i]) cnt++;
		}
		
		return cnt;
	}
}
