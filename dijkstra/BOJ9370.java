package dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ9370 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            solution(br, bw);
            bw.write("\n");
        }
        bw.flush();
    }

    public static class Edge{
        int to;
        int weight;

        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    public static void solution(BufferedReader br, BufferedWriter bw) throws Exception{
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 노드 개수
        int m = Integer.parseInt(st.nextToken()); // 간선 개수
        int t = Integer.parseInt(st.nextToken()); // 목적지 노드 개수

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken()); // 시작 노드
        int g = Integer.parseInt(st.nextToken()); // 지나간 노드
        int h = Integer.parseInt(st.nextToken()); // 지나간 노드

        ArrayList<Edge>[] adjs = new ArrayList[n+1]; // 인접 노드 정보
        for(int i = 0; i <= n; i++){
            adjs[i] = new ArrayList<Edge>();
        }

        int GH = 0;
        // 인접 노드 정보 저장
        for(int i = 0; i < m; i++){
           st = new StringTokenizer(br.readLine());
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());
           int w = Integer.parseInt(st.nextToken());
           adjs[a].add(new Edge(b, w));
           adjs[b].add(new Edge(a, w));
           if((a == g && b == h)||(a == h && b == g)){
               GH = w;
           }
        }

        // 목적지 노드 저장
        int[] dest = new int[t];
        for(int i = 0; i < t; i++){
            dest[i] = Integer.parseInt(br.readLine());
        }

        // start에서 목적지까지 가는 그냥 최단거리와, G-H 거쳐서 가는 최단거리 구해서 비교
        int[] distS = dijkstra(s, n, adjs);
        int[] distG = dijkstra(g, n, adjs);
        int[] distH = dijkstra(h, n, adjs);
        // start->g 가중치 + g->h 간선의 가중치 + h->목적지 가중치 == start -> 목적지 가중치
        // start->h 가중치 + h->g 간선의 가중치 + g->목적지 가중치 == start -> 목적지 가중치

        ArrayList<Integer> answer = new ArrayList<Integer>();
        for(int d : dest){
            int SD = distS[d];
            int SG = distS[g];
            int SH = distS[h];
            int HD = distH[d];
            int GD = distG[d];

            if((SD == SG + GH + HD) || (SD == SH + GH + GD)){
                answer.add(d);
            }
        }
        Collections.sort(answer);

        for(int ans : answer){
            bw.write(ans + " ");
        }

    }

    public static class Info {
        int node;
        int weight; // node 까지 오는데 필요했던 weight
        public Info(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }

    public static int[] dijkstra(int start, int n, ArrayList<Edge>[] adjs){
        // start -> dest[] 까지 가는데, 최단 거리로 갔고 g-h 간선을 통과했다.
        // 이 때 dest[] 에서 도착 가능한 목적지를 출력

        // 최단 거리 저장할 배열 선언
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Info> pq = new PriorityQueue<Info>(new Comparator<Info>(){
           @Override
           public int compare(Info i1, Info i2){
               return i1.weight - i2.weight;
           }
        });

        // Start 정보 넣기
        dist[start] = 0;
        pq.offer(new Info(start, 0));


        // g-h통과 여부
        boolean isPass = false;

        // 다익스트라 알고리즘 구현
        while(!pq.isEmpty()){
            Info info = pq.poll();
            if(info.weight > dist[info.node]) continue;
            // 현재 노드의 인접노드 정보를 순회한다.
            for(Edge adj : adjs[info.node]){
                // 일반 최단 거리 구함
                if(dist[adj.to] > adj.weight + info.weight){
                    dist[adj.to] = info.weight + adj.weight;
                    pq.offer(new Info(adj.to, dist[adj.to]));
                }

            }
        }
        return dist;
    }
}
