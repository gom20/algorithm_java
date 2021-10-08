package string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1157 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		str = str.toUpperCase();
		char[] arr = str.toCharArray();
		int[] check = new int[26];
		for(int i = 0; i < arr.length; i++) {
			int idx = (int)(arr[i])-65;
			check[idx]++;	
		}
		
		int idx = 0;
		int max = 0;
		int cnt = 1;
		for(int i = 0; i < check.length; i++ ) {
			if(max < check[i]) {
				max = check[i];
				idx = i;
				cnt= 1;
			} else if( max == check[i]) {
				cnt++;
			}
		}
		
		if(cnt >= 2) {
			bw.write("?");
		} else {
			int val_int = 65 + idx;			
			char val_char = (char)val_int;		
			bw.write(val_char);	
		}
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
