package math;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2775 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		for(int i= 0; i < t; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			bw.write(func(k, n)+"\n");
			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int func(int k, int n) {
		int people = 0; 
		
		if(k == 0) {
			return n;
		} else {
			for(int i = 1; i <= n; i++) {
				people += func(k-1, i);
			}
		}
		
		return people;
	}
}
