package string;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ5622 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] arr = br.readLine().toCharArray();
		
		String[] nums = new String[10];
		Arrays.fill(nums, "");
		
		int init = 65;
		for(int i = 2; i <= 9; i++) {
			int k = 3;
			if(i == 9 || i == 7) {
				k = 4;
			}
			for(int j = 0; j < k; j++) {
				nums[i] += (char) init++;				
			}
		}
		
		
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			int num = 0;
			for(int j = 2; j <= 9; j++) {
				if(nums[j].indexOf(String.valueOf(arr[i])) != -1) {
					num = j;
					break;
				}
			}
			sum+= num + 1;
			
		}
		bw.write(sum+"");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
