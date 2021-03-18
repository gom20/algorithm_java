package stack;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Stack;

public class BOJ10773 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		
		Stack<Integer> st = new Stack<Integer>();
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				st.pop();
			} else {				
				st.push(num);
			}
		}
		
		Iterator<Integer> iter = st.iterator();
		int sum = 0;
		while(iter.hasNext()) {
			sum += iter.next();
		}
		
		bw.write(sum+"\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
