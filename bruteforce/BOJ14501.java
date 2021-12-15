package bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14501 {
    public static int[] T, P, dp;
    public static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = new int[N+1];
        P = new int[N+1];
        dp = new int[N+1];
        StringTokenizer st = null;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++){
            recur(i, T[i], P[i], 0);
        }
        System.out.println(max);
    }

    public static int max = 0;
    public static void recur(int day, int time, int profit, int total){
        if(day + time >= N+1) {
            // 끝
            if(day + time == N+1){
                total += profit;
            }
            max = Math.max(max, total);
            return;
        }

        for(int i = day + time; i <= N; i++){
            recur(i, T[i], P[i], total+profit);
        }
    }
}
