package sort;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// counting sort
public class BOJ10989 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] result = new int[n];		
		int[] count = new int[10000+1];
		
		for(int i = 0; i < n ; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
			count[num]++;
		}
		
		for(int i = 1; i < count.length; i++) {				
			count[i] += count[i-1];
		}
		
		for(int i = n-1; i >= 0; i--) {
			result[count[arr[i]]-1] = arr[i];
			count[arr[i]] -= 1;
		}
		
		for(int num : result) {
			bw.write(num+"\n");
		}
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
