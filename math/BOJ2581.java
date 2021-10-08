package math;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2581 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for(int i = M; i <= N; i++) {
		
			boolean check = true;
			if(i == 1) {
				check = false;
			} else {				
				for(int j = 2; j < i; j++) {
					if(i%j == 0) {
						check = false;
						break;
					}
				}
			}
			if(check) {
				min = min < i ? min: i;
				sum += i;
			}
		}
		
		if(sum == 0) {
			bw.write(-1 +"\n");
		} else {
			bw.write(sum +"\n");
			bw.write(min +"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
}
