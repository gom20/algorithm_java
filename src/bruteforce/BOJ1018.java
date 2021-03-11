package bruteforce;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1018 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[][] arr = new String[N+1][M+1];
		
		for(int i = 1; i < N+1; i++) {
			String[] line = br.readLine().split("");
			for(int j = 1; j < M+1; j++) {
				arr[i][j] = line[j-1];
			}
		}
		
		
		int minCount = Integer.MAX_VALUE;
		for(int a = 1; a <= N-8+1 ; a++) {
			for(int b = 1; b <= M-8+1; b++) {
				int count = 0;
				
				
				for(int i = a; i < a+8; i++) {
					for(int j = b; j < b+8; j++) {
						if((i-a)%2 == 0) {
							if((j-b)%2 == 0){
								if(!arr[i][j].equals("B")) {
									count++;
								}
							}else {
								if(!arr[i][j].equals("W")) {
									count++;
								}
							}
						} else {
							if((j-b)%2 == 0){
								if(!arr[i][j].equals("W")) {
									count++;
								}
							} else {
								if(!arr[i][j].equals("B")) {
									count++;
								}
							}
						}
					} 
				} 
				
				if(minCount > count){
					minCount = count;
				}
				
				count = 0;
				
				for(int i = a; i < a+8; i++) {
					for(int j = b; j < b+8; j++) {
						if((i-a)%2 == 0) {
							if((j-b)%2 == 0){
								if(!arr[i][j].equals("W")) {
									count++;
								}
							}else {
								if(!arr[i][j].equals("B")) {
									count++;
								}
							}
						} else {
							if((j-b)%2 == 0){
								if(!arr[i][j].equals("B")) {
									count++;
								}
							} else {
								if(!arr[i][j].equals("W")) {
									count++;
								}
							}
						}							
					}
				}	
		
				
				if(minCount > count){
					minCount = count;
				}
			}
		}
		
		bw.write(minCount+"\n");
		
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
