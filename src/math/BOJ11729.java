package math;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ11729 {
	public static BufferedWriter bw;
	public static int cnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		bw.write((int)Math.pow(2, n)-1+"\n");
		hanoi(n, 1, 2, 3);
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void hanoi(int n, int start, int by, int end) throws IOException {
		cnt++;
		if(n == 1) {
			bw.write(start + " " + end + "\n");			
			return;
		}
		
		hanoi(n-1, start, end, by);
		bw.write(start + " " + end + "\n");
		
		
		hanoi(n-1, by, start, end);
	}
}
