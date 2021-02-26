package math;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1193 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		int idx = 1;
		int a = 0;
		int b = 0;
		Loop: while(true) {
			a = 0;
			b = 0;
			for(int i = 0; i < idx; i++) {
				if(idx%2 == 0) {
					a++;
					b = idx-a+1;
				} else {
					b++;
					a = idx-b+1;
				}
				cnt++;	
				if(cnt == num) {
					break Loop;
				}
			}
			
			idx++;
		}
		
		bw.write(a + "/" + b);
		bw.flush();
		bw.close();
		br.close();
	}
}
