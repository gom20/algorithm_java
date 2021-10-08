package sort;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BOJ1181 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		
		ArrayList<String> arr = new ArrayList<String>();
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			if(!arr.contains(str)) {	
				arr.add(str);
			}			
		}
		
		Collections.sort(arr, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				Integer o1Length = o1.length();
				Integer o2Length = o2.length();
				int result = 0;
				
				if(o1Length == o2Length) {
					char[] arr1 = o1.toCharArray();
					char[] arr2 = o2.toCharArray();
					
					for(int i = 0; i < o1Length; i++) {
						if(arr1[i] == arr2[i]) {
							continue;
						} else {
							int n1 = Integer.valueOf(arr1[i]);
							int n2 = Integer.valueOf(arr2[i]);
							if(n1 > n2) {
								result = 1;
							} else {
								result = -1;
							}
							break;
						}
					}
				} else {
					result = o1Length.compareTo(o2Length);
				}
				return result;
			}	
		});
		
	
		for(String str : arr) {
			bw.write(str+"\n");
		}		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
