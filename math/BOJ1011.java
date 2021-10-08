package math;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 1+ 2+ ... + (n-1) + n + (n-1) + ... + 1 = nÀÇ Á¦°ö
public class BOJ1011 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int i =0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int dist = y - x;
			
			int cnt = 0;
			if(dist < 4) {
				cnt = dist;
			} else {
				int n = (int) Math.sqrt(dist);
				
				cnt = n*2-1;
			
				int remain = dist%(int)Math.pow(n, 2);
				while(remain > 0) {
					cnt += remain/n;
					remain = remain%n;
					if(remain == 0) break;
					n--;
				}
			}
			bw.write(cnt+"\n");
		}

			
		bw.flush();
		bw.close();
		br.close();
	}
}
