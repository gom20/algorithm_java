package dp;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2447 {
	public static String[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		arr = new String[n+1][n+1];
		for(int i = 0; i < n+1; i++) {
			for(int j = 0; j < n+1; j++) {
				arr[i][j] = " ";
			}
		}
		
		setStar(1, 1, n);
		drawStar(bw, n);
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void setStar(int row, int col, int num ) {
        if (num == 1) {
            arr[row][col] = "*";
        } else {
            int newNum = num / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (i == 1 && j == 1) {
                        arr[i][j] = "*";
                    } else {
                    	setStar(row + newNum * i, col + newNum * j, newNum);
                    }
                }
            }
        }

	}
	
	public static void drawStar(BufferedWriter bw, int num) throws IOException {
		for(int i = 1; i <= num; i++) {
			for(int j =1; j <= num; j++) {
				bw.write(arr[i][j]);
			}
			bw.write("\n");
		}
	}
	
}




