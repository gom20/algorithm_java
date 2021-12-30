package dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ11779 {
    static class Edge {
        int to;
        int cost;
        Edge(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }

    static int N, M, S, E;
    static ArrayList<Edge>[] adjs;
    static int[][] cost;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adjs = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            adjs[i] = new ArrayList<Edge>();
        }
        cost = new int[N+1][2];
        for(int i = 1; i <= N; i++){
            cost[i][0] = Integer.MAX_VALUE;
        }

        StringTokenizer st = null;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adjs[from].add(new Edge(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dijkstra();


        Stack<Integer> path = new Stack<>();
        path.push(E);
        while(true){
            int prev = cost[path.peek()][1];
            path.push(prev);
            if(prev == S) break;
        }

        bw.write(cost[E][0] + "\n");
        bw.write(path.size()+ "\n");
        StringBuilder sb = new StringBuilder();
        while(!path.isEmpty()){
            sb.append(path.pop() + " ");
        }
        bw.write(sb.toString());
        bw.flush();
    }
    static class Info {
        int node;
        int accuCost;
        public Info(int node, int accuCost){
            this.node = node;
            this.accuCost = accuCost;
        }
    }
    public static void dijkstra(){
        cost[S][0] = 0;
        cost[S][1] = S;
        PriorityQueue<Info> pq = new PriorityQueue<Info>(
                new Comparator<Info>() {
                    @Override
                    public int compare(Info o1, Info o2) {
                        return o1.accuCost - o2.accuCost;
                    }
                }
        );
        pq.offer(new Info(S, 0));

        while(!pq.isEmpty()){
            Info info = pq.poll();
            if(info.accuCost > cost[info.node][0]) continue;
            for(Edge edge : adjs[info.node]){
                if(cost[edge.to][0] <= info.accuCost + edge.cost) continue;
                cost[edge.to][0] = info.accuCost + edge.cost;
                cost[edge.to][1] = info.node;
                pq.offer(new Info(edge.to, cost[edge.to][0]));
            }
        }
    }
}
