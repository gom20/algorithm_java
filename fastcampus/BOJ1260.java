package fastcampus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1260 {

    public static int[][] graph;
    public static boolean[] visited;
    public static int start, N, M;
    public static StringBuilder sb;

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        graph = new int[N+1][N+1];
        visited = new boolean[N+1];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        sb = new StringBuilder();
    }

    public static void output() throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
    }

    public static void dfs(int vertex){
        sb.append(vertex).append(" ");
        visited[vertex] = true;

        for(int i = 1; i <= N; i++){
            if(graph[vertex][i] == 0) continue;
            if(visited[i]) continue;
            dfs(i);
        }
    }

    public static void bfs(int vertex){
        sb.append(vertex).append(" ");
        visited[vertex] = true;

        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(vertex);

        while(!que.isEmpty()){
            vertex = que.poll();

            for(int i = 1; i <= N; i++){
                if(graph[vertex][i] == 0) continue;
                if(visited[i]) continue;
                que.offer(i);
                sb.append(i).append(" ");
                visited[i] = true;
            }
        }

    }

    public static void main(String[] args) throws Exception{
        input();

        dfs(start);
        sb.append("\n");

        for(int i = 1; i <= N; i++){
            visited[i] = false;
        }
        bfs(start);

        output();
    }
}
