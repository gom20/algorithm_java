package math;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ11653 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int x = 2;
		
		while(true) {
			if(n%x == 0) {
				n = n/x;
				bw.write(x+"\n");
			} else {
				x = x+1;
			}
			
			if(n == 1) break;
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
