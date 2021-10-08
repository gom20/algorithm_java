package fastcampus;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ15649 {

    public static int N, M;
    public static StringBuilder sb = new StringBuilder();
    public static int[] selected, used;

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        br.close();
    }

    public static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void recurFunc(int k){
        if(k == M+1) {
            for (int i = 1; i <= M; i++) {
                sb.append(selected[i]);
                sb.append(" ");
            }
            sb.append("\n");
        } else {
            for(int cand = 1; cand <= N; cand++){
                int isUsed = used[cand];
                if(isUsed == 0){
                    selected[k] = cand;
                    used[cand] = 1;
                    recurFunc(k+1);
                    selected[k] = 0;
                    used[cand] = 0;
                }

            }
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        selected = new int[M+1];
        used = new int[N+1];
        recurFunc(1);
        output();
    }
}
