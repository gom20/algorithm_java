import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ2740 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int rowA =  Integer.parseInt(st.nextToken());
		int colA =  Integer.parseInt(st.nextToken());
		
		int[][] arrA = new int[rowA][colA];
		for(int i = 0; i < rowA; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < colA; j++) {
				arrA[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int rowB =  Integer.parseInt(st.nextToken());
		int colB =  Integer.parseInt(st.nextToken());
		
		int[][] arrB = new int[rowB][colB];
		for(int i = 0; i < rowB; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < colB; j++) {
				arrB[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] result = new int[rowA][colB];
		for(int i = 0; i < rowA; i++) {
			for(int j = 0; j < colB; j++) {
				for(int k = 0; k < colA; k++) {
					int num = arrA[i][k]*arrB[k][j];
					result[i][j] += num; 
				}
			}
		}

		for(int i = 0; i < rowA; i ++) {
			for(int j = 0; j < colB; j++) {
				bw.write(result[i][j] + " ");
			}
			bw.write("\n");
			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}



