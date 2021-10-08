package bruteforce;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2231 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		int sum = 0;
		int[] nums = new int[1000001];
		for(int i = 1; i < 1000001; i++) {
			sum = 0;
			sum += i;
			char[] arr = String.valueOf(i).toCharArray();
			for(int j = 0; j < arr.length; j++) {				
				sum += Character.getNumericValue(arr[j]);
			}
			nums[i] = sum;
		
		}
		
		int val = 0;
		for(int i = 1; i < 1000001; i++) {
			if(nums[i] == num) {
				val = i;
				break;
			}
		}
		bw.write(val +"\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
