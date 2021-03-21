package queue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ11866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i = 1; i <= n; i++) {
			list.add(i);
		}
		
		
		bw.write("<");
		int interval = 0;
		while(!list.isEmpty()) {
			interval++;
			if(interval == k) {
				if(list.size() > 1) {					
					bw.write(list.pop() + ", ");
				} else {
					bw.write(list.pop()+">");
				}
				interval = 0;
			} else {				
				list.add(list.pop());
			}
		}
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
