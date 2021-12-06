package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1238 {

    public static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    public static class Info implements Comparable<Info> {
        int node;
        int weight;

        public Info(int node, int weight){
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Info o){
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // Node의 개수
        int M = Integer.parseInt(st.nextToken()); // Edge의 개수 (단방향)
        int X = Integer.parseInt(st.nextToken()); // Destination Node

        // 인접 노드 리스트 생성
        ArrayList<Edge> adjs[] = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            adjs[i] = new ArrayList<Edge>();
        }
        // 인접 노드 정보 저장
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjs[from].add(new Edge(to, weight));
        }

        int max = Integer.MIN_VALUE;
        // 오고 가는데 가장 오래 걸리는 노드의 왕복 시간을 출력
        for(int i = 1; i <= N; i++){
            // 오고가는데 걸리는 시간이므로 시작점 -> 목적지 / 목적지 -> 시작점 값을 더해줘야 함.
            max = Math.max(max, dijkstra(i, X, N, adjs) + dijkstra(X, i, N, adjs));
        }

        System.out.println(max);
    }

    public static int dijkstra(int S, int X, int N, ArrayList<Edge>[] adjs){
        // S 시작점, X 목적지, N 노드개수
        // 최소 가중치 갱신하면서 저장할 배열 생성
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Info> pq = new PriorityQueue<Info>();
        pq.offer(new Info(S, 0));
        dist[S] = 0;

        while(!pq.isEmpty()){
            Info info = pq.poll();
            if(dist[info.node] < info.weight) continue;
            for(Edge edge : adjs[info.node]){
                // 현재 노드의 인접 노드 탐색
                if(info.weight + edge.weight < dist[edge.to]){
                    dist[edge.to] = info.weight + edge.weight;
                    pq.offer(new Info(edge.to, dist[edge.to]));
                }
            }
        }

        return dist[X];
    }
}
