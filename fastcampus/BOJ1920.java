package fastcampus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920 {

    public static int n, m;
    public static int[] N, M;
    public static StringBuilder sb;

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        N = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= n; i++){
            N[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        M = new int[m+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ; i <= m; i++){
            M[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void output() throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static boolean find(int[] N, int L, int R, int X){
        //정렬된 N[L] ~ N[R] 내에서 X가 있는지 찾는다.
        while(L <= R){
            int mid = (L+R)/2;
            if(N[mid] > X){
                R = mid - 1;
            }
            if(N[mid] < X){
                L = mid +1;
            }
            if(N[mid] == X){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        input();
        sb = new StringBuilder();

        Arrays.sort(N, 1, n+1);

        for(int i = 1; i <= m; i++){
            if(find(N, 1, n, M[i])){
                sb.append("1");
            } else {
                sb.append("0");
            }
            sb.append("\n");
        }
        output();
    }

}
