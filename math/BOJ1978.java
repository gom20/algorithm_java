package math;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1978 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cnt = 0;
		for(int i= 0; i < t; i++) {
			int n = Integer.parseInt(st.nextToken());
			
			boolean check = true;
			if(n == 1) {
				check = false;
			} else {
				for(int j = 2; j < n; j++) {
					if(n%j == 0) {
						check = false;
						break;
					}
				}
			}
			
			if(check) {
				cnt++;
			}
			
		}
		
		bw.write(cnt+"\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
