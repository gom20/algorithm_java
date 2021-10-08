package string;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2941 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		
		String[] str = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		String word = br.readLine();
		
		for(int i = 0; i < str.length; i++) {
			word = word.replaceAll(str[i], "#");
		}
		
		bw.write(word.length()+"");
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
