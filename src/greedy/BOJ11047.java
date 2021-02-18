package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11047 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		for(int i = 0; i < n ;i ++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int cnt = 0;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = n-1; i >= 0 ; i--) {
			if(k == 0) break;
			if(k/arr[i] >= 1) {
				cnt += k/arr[i];
				k = k%arr[i];
			}
			
		}
		bw.write(""+cnt);
		bw.flush();
		bw.close();
		br.close();				
		
	}
}
