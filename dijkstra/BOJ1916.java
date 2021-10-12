package dijkstra;


import java.util.*;
import java.io.*;
import java.lang.*;

public class BOJ1916 {

    public static PriorityQueue<Info> pq;
    public static ArrayList<Edge>[] edges;
    public static int dist[];
    public static int N, M, start, end;

    public static class Info implements Comparable<Info> {
        int node, dist;

        public Info(int node, int dist){
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Info o){
            return this.dist - o.dist;
        }
    }

    public static class Edge {
        int to, weight;

        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    public static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        edges = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) edges[i] = new ArrayList<Edge>();

        StringTokenizer st = null;
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            edges[Integer.parseInt(st.nextToken())].add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<Info>();

        dist = new int[N+1];
        for(int i= 1; i <= N; i++){
            dist[i] = Integer.MAX_VALUE;
        }

    }

    public static void dijkstra(){
        dist[start] = 0;
        pq.offer(new Info(start, dist[start]));

        while(!pq.isEmpty()){
            Info info = pq.poll();
            if(info.dist > dist[info.node]) continue;
            for(Edge adj : edges[info.node]){
                if(adj.weight + dist[info.node] >= dist[adj.to]) continue;
                dist[adj.to] = adj.weight + dist[info.node];
                pq.offer(new Info(adj.to, dist[adj.to]));
            }
        }

    }

    public static void main(String[] args) throws Exception{
        input();
        dijkstra();

        System.out.print(dist[end]);
    }

}
