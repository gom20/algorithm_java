package math;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class BOJ9020 {
	
	public static boolean[] primeNums;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		setPrimeNums();

		
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			LinkedList<Integer> nums = getPrimeNums(n);
			int diff = Integer.MAX_VALUE;
			int a = 0; 
			int b = 0;
			while(nums.size() > 0) {
				int j = nums.peek();
				nums.pop();
				if(j == n-j) {
					diff = 0;
					a = j;
					b = n-j;
					break;
				} else {
					if(nums.contains(n-j)) {
						nums.remove(nums.indexOf(n-j));
						if(Math.abs(j-(n-j)) < diff) {
							a = j;
							b = n-j;
						}
					}
				}

			}
			bw.write(a+" " + b +"\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static LinkedList<Integer> getPrimeNums(int n) {
		LinkedList<Integer> nums = new LinkedList<Integer>();
		for(int i = 1; i < n; i++) {
			if(primeNums[i]) {
				nums.add(i);
			}
		}
		return nums;
	}
	
	public static void setPrimeNums() {
		int n = 10000;
		primeNums = new boolean[n+1];
		Arrays.fill(primeNums, true);
		
		
		for(int i = 1; i < n/2; i++) {
			if(i == 1) {
				primeNums[i] = false;
				continue;
			} else {
				for(int j = i+i; j <= n; j+=i) {
					primeNums[j] = false;
				}
			}
		}
		
	}
}
