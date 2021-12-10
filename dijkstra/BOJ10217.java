package dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ10217 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            bw.write(solution(br) + "\n");
        }
        bw.flush();
    }

    public static class Edge{
        int to;
        int cost;
        int time;
        public Edge(int to, int cost, int time){
            this.to = to;
            this.cost = cost;
            this.time = time;
        }
    }

    public static class Info{
        int node;
        int accuCost;
        int accuTime;
        public Info(int node, int accuCost, int accuTime){
            this.node = node;
            this.accuCost = accuCost;
            this.accuTime = accuTime;
        }
    }

    public static String solution(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 노드의 개수
        int M = Integer.parseInt(st.nextToken()); // 최대 비용
        int K = Integer.parseInt(st.nextToken()); // 간선 개수

        // 인접 노드 리스트 생성
        ArrayList<Edge>[] adjs = new ArrayList[N+1];
        for(int i = 0; i <= N; i++){
            adjs[i] = new ArrayList<Edge>();
        }

        // 인접 노드 정보 Input 처리
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            adjs[from].add(new Edge(to, cost, time));
        }

        //dp[i][j] = 시작점에서 i까지 비용 j로 가는데 걸리는 최소 시간
        int[][] dp = new int[N+1][M+1];
        for(int i = 0; i <= N; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        // 시간 오름차순 정렬
        PriorityQueue<Info> pq = new PriorityQueue<Info>(new Comparator<Info>(){
            @Override
            public int compare(Info i1, Info i2){
                return i1.accuTime - i2.accuTime;
            }
        });

        // 시작 Node(1번)에서 1번 Node까지 0의 비용으로 0시간걸림
        dp[1][0] = 0;
        pq.offer(new Info(1, 0, 0));

        while(!pq.isEmpty()){
            Info cur = pq.poll();

            // 시작 노드에서 cur.node 까지 cur.accCost 비용으로 간 dp에 저장된 최소 시간보다
            // 현재 누적해서 온 시간이 클 경우 갱신을 하지 않는다.
            if(dp[cur.node][cur.accuCost] < cur.accuTime) continue;

            for(Edge adj : adjs[cur.node]){
                int accuTime = cur.accuTime + adj.time;
                int accuCost = cur.accuCost + adj.cost;

                // 누적해온 비용이 M보다 커졌다면 갱신하지 않는다.
                if(accuCost > M) continue;

                // 시작 노드에서 adj.to까지 accuCost 비용으로 간 dp 저장된 최소 시간이
                // 현재까지 계산된 누적 최소 시간보다 같거나 작다면 갱신하지 않는다.
                if(dp[adj.to][accuCost] <= accuTime) continue;

                // 시작 노드에서 adj.to까지 accuCost비용을 내고 dp[adj.to][accuCost] 최소 시간이 걸렸다.
                // 그렇다면 adj.to까지 accuCost 이상의 비용을 냈는데 dp[adj.to][accuCost] 최소 시간보다 오래 걸렸다면
                // 최소 시간을 갱신해준다.
                for(int i = accuCost; i <= M; i++){
                    if(dp[adj.to][i] > accuTime){
                        dp[adj.to][i] = accuTime;
                    }
                }
                dp[adj.to][accuCost] = accuTime;
                pq.offer(new Info(adj.to, accuCost, accuTime));

            }
        }

        int min = Integer.MAX_VALUE;
        for(int j = 0; j <= M; j++){
            min = Math.min(min, dp[N][j]);
        }
        return (min == Integer.MAX_VALUE)? "Poor KCM" : String.valueOf(min);
    }
}
