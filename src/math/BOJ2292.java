package math;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2292 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long n = Integer.parseInt(br.readLine());
		int cnt = 1;
		if(n == 1) {
			cnt = 1;
		} else {
			int t = 2;
			int i = 1;
			while(true) {				
				t= t + 6*i;
				if(n < t) {
					cnt = i+1;
					break;
				}
				i++;
			}
			
		}
		
		bw.write(cnt+"");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
