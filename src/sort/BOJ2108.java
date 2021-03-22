package sort;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BOJ2108 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int pCnt[] = new int[4001];
		int nCnt[] = new int[4001];
		
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		double sum = 0;
		int avg = 0;
		int n = Integer.parseInt(br.readLine());
		int nums[] = new int[n];
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			sum += num;
			if(max < num) {
				max = num;
			}
			if(min > num) {
				min = num;
			}
			
			nums[i] = num;
			
			if(num >= 0) {
				pCnt[num] +=1;
			} else {
				nCnt[num*-1] +=1;
			}
			
		}
		
		//Æò±Õ
		avg = (int) Math.round(sum/n);
		bw.write(avg+"\n");

		//Áß¾Ó°ª
		Arrays.sort(nums);
		bw.write(nums[nums.length/2]+"\n");
		
		
		//ÃÖºó°ª
		int cMax = Integer.MIN_VALUE;
		for(int i = 0; i < 4001; i++) {
			if(cMax < pCnt[i]) {
				cMax = pCnt[i];
			}
			if(i != 0) {				
				if(cMax < nCnt[i]) {
					cMax = nCnt[i];
				}
			}
		}
		
		ArrayList<Integer> candidates = new ArrayList<Integer>();
		
		for(int i = 0; i < 4001; i++) {
			if(cMax == pCnt[i]) {
				candidates.add(i);
			}
			if(i != 0) {				
				if(cMax == nCnt[i]) {
					candidates.add(i*-1);
				}
			}
		}
		
		Collections.sort(candidates);
		if(candidates.size() > 1) {
			bw.write(candidates.get(1)+"\n");
		} else {
			bw.write(candidates.get(0)+"\n");
		}
		
		
		
		//¹üÀ§
		bw.write(Math.abs(max-min)+"\n");
		
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
