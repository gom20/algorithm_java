package sort;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ1427 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[] arr = br.readLine().toCharArray();
		int[] numArr = new int[arr.length];
		
		for(int i =0; i < arr.length; i++) {
			numArr[i] = Character.getNumericValue(arr[i]);
		}
		
		Arrays.sort(numArr);
		
		for(int i = numArr.length-1; i >=0; i--) {
			bw.write(numArr[i]+"");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
