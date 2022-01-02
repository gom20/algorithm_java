package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1167 {

    static int V;
    static class Edge{
        int to;
        int weight;
        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
    static ArrayList<Edge>[] adjs = null;

    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        adjs = new ArrayList[V+1];
        for(int i = 1; i <= V; i++){
            adjs[i] = new ArrayList<Edge>();
        }

        StringTokenizer st = null;
        for(int i = 1; i <= V; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while(true){
                int to = Integer.parseInt(st.nextToken());
                if(to == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                adjs[from].add(new Edge(to, weight));
            }
        }

        // 임의 정점에서 가장 먼 노드 구하기
        visited = new boolean[V+1];
        visited[1] = true;
        dfs(1, 0);

        // 위에서 구한 노드에서 가장 거리 구하기
        max = 0;
        visited = new boolean[V+1];
        visited[target] = true;
        dfs(target, 0);

        System.out.println(max);
    }
    static int max, target;
    public static void dfs(int v, int weight){
        if(max < weight){
            max = weight;
            target = v;
        }
        for(Edge e : adjs[v]){
            if(visited[e.to]) continue;
            visited[e.to] = true;
            dfs(e.to, e.weight + weight);
        }
    }
}
