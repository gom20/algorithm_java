package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ21937 {

    public static int N, M, X, count;

    public static ArrayList<Integer>[] graph;
    public static boolean visit[];
    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) graph[i] = new ArrayList<Integer>();

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            // B를 하기 위해서는 A가 선행되어야 함.
            graph[B].add(A);
        }
        X = Integer.parseInt(br.readLine());
    }

    public static void bfs(int start){
        //최소 거리 단말 찾기
        visit = new boolean[N+1];
        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(start);

        while(!que.isEmpty()){
            int node = que.poll();
            if(visit[node]) continue;
            visit[node] = true;
            for(int adj : graph[node]){
                que.offer(adj);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        input();
        bfs(X);
        for(int i = 1; i <= N; i++){
            if(i == X) continue;
            if(visit[i]) count++;
        }

        System.out.print(count);
    }

}
