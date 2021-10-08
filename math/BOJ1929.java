package math;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1929 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] arr = br.readLine().split(" ");
		int N = Integer.parseInt(arr[0]);
		int M = Integer.parseInt(arr[1]);
		
		boolean[] nonPrimeNums = new boolean[M+1];
		
		for(int i = 1; i <= M; i++) {
			if(i == 1) {
				nonPrimeNums[i] = true;
			} else {
				int num = i + i;
				while(num <= M) {		
					nonPrimeNums[num] = true;
					num += i;
				}
			}
		}
		
		for(int i = N; i <= M; i++) {
			if(!nonPrimeNums[i]) {
				bw.write(i + "\n");
			}
		}
		
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
