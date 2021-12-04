package math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1010 {

    public static Integer memozation[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        memozation = new Integer[30][30]; // N, M 범위 1~29
        StringTokenizer st = null;
        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            // n개의 다리중 m개 선택
            bw.write(combination(n, m) + "\n");
        }
        bw.flush();
    }

    public static int combination(int n, int m){
        // nCm
        // nCm = n-1Cm-1 + n-1Cm
        if(n == m || m == 0) return 1;
        if(memozation[n][m] != null) return memozation[n][m];

        memozation[n][m] = combination(n-1, m-1) + combination(n-1, m);
        return memozation[n][m];
    }

}
