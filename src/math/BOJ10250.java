package math;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ10250 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int i = 0; i < t ; i++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			
			
			int y = n%h;
			int x = n/h + 1;
			if(n%h == 0) {
				y = h;
				x = x-1;
			}
			
			int result = y*100 + x;
			bw.write(result+"\n");
		}
		
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
