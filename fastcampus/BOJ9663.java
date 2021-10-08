package fastcampus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ9663 {

   // N-Queen
    public static int N;
    public static int num;
    public static int[] cols;

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        cols = new int[N];
    }

    public static void output() throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(num));
        bw.flush();
    }

    public static boolean possible(int k, int cand){
        // (k, cand) 가 가능한지 체크
        for(int row = 0; row < k; row++){
            int col = cols[row];
            if(col == cand) return false;
            if(Math.abs(k-row) == Math.abs(cand-col)) return false;
        }
        return true;
    }

    public static void recurFunc(int k) {
        if(k == N){
            num++;
        } else {
            for(int cand = 0; cand < N; cand++){
                if(possible(k, cand)){
                    cols[k] = cand;
                    recurFunc(k+1);
                    cols[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        input();

        recurFunc(0);

        output();
    }

}
