package bellmanford;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11657 {

    public static class Edge{
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 노드 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수
        int start = 1 ;

        ArrayList<Edge> edges = new ArrayList<Edge>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges.add(new Edge(from, to, w));
        }

        long[] dist = new long[N+1];
        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);
        dist[start] = 0;

        boolean isNegativeCycle = false;
        for(int i = 0; i < N; i++){
            for(Edge edge: edges){
                int from = edge.from;
                int to = edge.to;
                int weight = edge.weight;

                if(dist[from] == INF) continue;
                if(dist[to] > dist[from] + weight){
                    dist[to] = dist[from] + weight;
                    if(i == N-1) {
                        isNegativeCycle = true;
                    }
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        if(isNegativeCycle){
            bw.write(-1 + "\n");
        } else {
            for(int i = 2; i <= N; i++){
                dist[i] = (dist[i] == INF) ? -1 : dist[i];
                bw.write(dist[i] + "\n");
            }
        }
        bw.flush();
    }
}
