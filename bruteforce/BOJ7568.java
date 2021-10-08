package bruteforce;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ7568 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		ArrayList<int[]> list = new ArrayList<int[]>();
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[2];
			arr[0] =Integer.parseInt(st.nextToken());
			arr[1] =Integer.parseInt(st.nextToken());
			
			list.add(arr);
		}
	
		for(int i = 0 ; i < n; i++) {
			int[] target = list.get(i);
			int rank = 1;
			for(int j= 0; j < n; j++) {
				if(target[0]< list.get(j)[0] && target[1] < list.get(j)[1]) {
					rank ++;
				}
			}
			bw.write(rank+" ");

		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
