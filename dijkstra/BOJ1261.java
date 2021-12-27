package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1261 {

    static int M, N;
    static int[][] map;
    static int[][] counts;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        counts = new int[M +1][N +1];
        for(int i = 1; i <= M; i++){
            for(int j = 1; j <= N; j++){
                counts[i][j] = Integer.MAX_VALUE;
            }
        }
        map = new int[M +1][N +1];
        for(int i = 1; i <= M; i++){
            char[] arr = br.readLine().toCharArray();
            for(int j = 1; j <= N; j++){
                map[i][j] = Integer.parseInt(String.valueOf(arr[j-1]));
            }
        }
        dijkstra();

        System.out.println(counts[M][N]);
    }

    static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static class Info implements Comparable<Info> {
        int x;
        int y;
        int accCnt;

        public Info(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.accCnt = count;
        }

        @Override
        public int compareTo(Info o) {
            return this.accCnt - o.accCnt;
        }
    }
    public static void dijkstra(){
        PriorityQueue<Info> pq = new PriorityQueue<Info>();
        counts[1][1] = 0;
        pq.offer(new Info(1, 1, 0));

        while(!pq.isEmpty()){
            Info info = pq.poll();
            int x = info.x;
            int y = info.y;
            int accuCnt = info.accCnt;

            if(counts[x][y] < accuCnt) continue;

            for(int[] d : dir ){
                int nx = x + d[0];
                int ny = y + d[1];
                if(!isValid(nx, ny)) continue;

                int nCnt = accuCnt + (map[nx][ny] == 1 ? 1 : 0);
                if(nCnt < counts[nx][ny]) {
                    counts[nx][ny] = nCnt;
                    pq.offer(new Info(nx, ny, nCnt));
                }
            }
        }
    }

    public static boolean isValid(int nx, int ny){
        if(nx < 1|| ny < 1 || nx > M || ny > N) return false;
        return true;
    }
}
