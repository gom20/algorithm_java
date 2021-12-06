package dijkstra;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ4485 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int idx = 1;
        while(true){
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;
            int[][] map = new int[N][N];
            StringTokenizer st = null;
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            bw.write("Problem " + idx + ": "+ solution(N, map) + "\n");
            idx++;
        }
        bw.flush();

    }

    public static class Edge {
        int toX;
        int toY;
        int weight;

        public Edge(int toX, int toY, int weight){
            this.toX = toX;
            this.toY = toY;
            this.weight = weight;
        }
    }

    public static class Info implements Comparable<Info>{
        int x;
        int y;
        int dist;

        public Info(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Info o){
            return this.dist - o.dist;
        }
    }

    // 현 노드에서 접근 가능한 좌표를 구할때 사용할 정보 (상하좌우)
    public static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static int solution(int N, int[][] map){
        // 최단 거리를 담을 배열 생성
        int[][] dist = new int[N][N];
        for(int i = 0; i < N; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // 각 노드의 인접 노드 리스트 생성
        ArrayList<Edge>[][] adjs = new ArrayList[N][N];
        for(int i = 0 ;i< N; i++){
            for(int j =0; j < N; j++){
                adjs[i][j] = new ArrayList<Edge>();
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                for(int[] d : dir){
                    int nx = i + d[0];
                    int ny = j + d[1];
                    if(isValid(nx, ny, N)){
                        adjs[i][j].add(new Edge(nx, ny, map[nx][ny]));
                    }
                }
            }
        }

        // 시작 노드 넣어주기.
        PriorityQueue<Info> pq = new PriorityQueue<Info>();
        pq.offer(new Info(0, 0, map[0][0]));

        while(!pq.isEmpty()){
            Info info = pq.poll();
            if(info.dist > dist[info.x][info.y]) continue;
            for(Edge edge : adjs[info.x][info.y]){
                if(info.dist + edge.weight < dist[edge.toX][edge.toY]){
                    dist[edge.toX][edge.toY] = info.dist + edge.weight;
                    pq.offer(new Info(edge.toX, edge.toY, info.dist + edge.weight));
                }
            }
        }

        return dist[N-1][N-1];
    }

    public static boolean isValid(int x, int y, int N){
        if(x < 0 || y < 0 || x >= N || y >= N) return false;
        return true;
    }
}
