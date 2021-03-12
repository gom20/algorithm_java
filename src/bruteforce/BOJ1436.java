package bruteforce;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1436 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		int i = 0;
		while(true) {
			if(String.valueOf(i).contains("666")) {
				cnt++;
			}
			if(cnt == n){
				bw.write(i+"\n");
				break;
			}
			i++;
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
