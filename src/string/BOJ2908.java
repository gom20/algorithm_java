package string;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ2908 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		char[] a = st.nextToken().toCharArray();
		char[] b = st.nextToken().toCharArray();
		
		String a1 = "";
		for(int i = a.length-1; i >=0; i--) {
			a1 += String.valueOf(a[i]);
		}
		
		String b1 = "";
		for(int i = b.length-1; i >=0; i--) {
			b1 += String.valueOf(b[i]);
		}
		
		int a2 = Integer.parseInt(a1);
		int b2 = Integer.parseInt(b1);
		
		int result = a2 > b2 ? a2: b2;
		bw.write(result + "");
		
				
		bw.flush();
		bw.close();
		br.close();
	}
}
