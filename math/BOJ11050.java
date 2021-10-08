package math;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ11050 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		bw.write(func(n)/(func(n-k)*func(k)) + "");
		
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int func(int a) {
		if(a == 1 || a == 0) {
			return 1;
		} else {
			return a*func(a-1);
			
		}
	}
}
