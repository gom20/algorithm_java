package math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11051 {

    public static Integer memozation[][];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        memozation = new Integer[1001][1001];
        System.out.println(combination(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }

    public static int combination(int n, int m){
        // nCm
        // nCm = n-1Cm-1 + n-1Cm
        if(n == m || m == 0) return 1;
        if(memozation[n][m] != null) return memozation[n][m];

        memozation[n][m] = (combination(n-1, m-1) + combination(n-1, m))%10007;
        return memozation[n][m]%10007;
    }
}
