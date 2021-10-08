package math;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2839 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		if(n%5 == 0) {
			cnt = n/5;
		} else {	
			while(n >= 3) {				
				n = n-3;
				cnt++;
				if(n%5 ==0) {
					cnt += n/5;
					break;
				}
				if(n == 2 || n == 1) {
					cnt = -1;
					break;
				}
			}
		}	
		
		bw.write(cnt+"\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
