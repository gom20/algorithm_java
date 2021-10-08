package fastcampus;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15651 {
    public static StringBuilder sb = new StringBuilder();
    public static int N, M;
    public static int[] selected;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M+1];
        br.close();
    }

    public static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void recFunc(int k){
        if(k == M + 1){
            for(int i = 1; i <=M;i++){
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        } else {
            for(int cand = 1; cand <= N; cand++){
                selected[k] = cand;
                recFunc(k+1);
            }
        }

    }

    public static void main(String args[]) throws Exception {
        input();
        recFunc(1);
        output();
    }

}
