package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1110 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		int count = 0; 
		int origin = num;
		
		while(true) {	
			int temp;
			int newNum;
			if(num < 10) {
				temp = num;
				newNum = num*10 + temp;
			} else {
				temp = num/10 + num%10;
				newNum = (num%10*10) + temp%10;
			
			}
			
			count++;
			if(newNum == origin) {
				break;
			}
			num = newNum;
		}
		
		System.out.println(count);
	}
}

