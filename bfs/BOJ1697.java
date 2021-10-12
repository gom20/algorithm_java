package bfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.*;

public class BOJ1697 {

    public static int N, K, ans;
    public static boolean[] visit;

    public static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visit = new boolean[100001];
    }

    public static boolean isValid(int n){
        if(n < 0 || n > 100000) return false;
        if(visit[n]) return false;
        if(n >= 0 && n <= 100000) return true;
        return false;
    }
    public static void bfs(){
        visit[N] = true;
        Queue<int[]> que = new LinkedList<int[]>();
        que.offer(new int[]{N, 0});

        while(!que.isEmpty()){
            int[] elem = que.poll();
            int n = elem[0];
            int cnt = elem[1];
            if(n == K){
                ans = cnt;
                break;
            } else {
                if(isValid(n+1)) {que.offer(new int[]{n+1, cnt+1}); visit[n+1] = true;}
                if(isValid(n-1)) {que.offer(new int[]{n-1, cnt+1}); visit[n-1] = true;}
                if(isValid(n*2)) {que.offer(new int[]{n*2, cnt+1}); visit[n*2] = true;}
            }
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        if(K < N){
            ans = N - K;
        } else {
            bfs();
        }
        System.out.println(ans);
    }

}