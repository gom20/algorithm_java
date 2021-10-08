package math;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2869 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] arr = br.readLine().split(" ");
		int A = Integer.parseInt(arr[0]);
		int B = Integer.parseInt(arr[1]);
		int V = Integer.parseInt(arr[2]);
		
		int cnt = (V-A)/(A-B)+1;
		if((V-A)%(A-B) > 0) {
			cnt += 1;
		} 
		
		bw.write(cnt+"");
		bw.flush();

	}
}
