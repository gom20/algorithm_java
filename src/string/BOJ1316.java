package string;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ1316 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		
		int count = 0;
		for(int k = 0; k < n; k++) {			
			char[] charArr = br.readLine().toCharArray();
			
			String str = "";
			boolean check = true;
			for(int i = 0; i < charArr.length; i++) {
				String x = String.valueOf(charArr[i]);
				if(str.indexOf(x) == -1) {
					str+=x;
				} else {
					if(str.charAt(str.length()-1) != charArr[i]) {
						check = false;
						break;
					} else {
						str +=x;
					}
				}
			}
			if(check) count++;	
		}
		bw.write(count+"");
	
		
		bw.flush();
		bw.close();
		br.close();
	}
}
