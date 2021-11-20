package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7569 {

    public static int[][][] box;
    public static int[][] dir = new int[][]{{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
    public static int M, N, H;
    public static Queue<Integer> que;

    public static void main(String[] args) throws Exception {
        input();
    }

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[N +1][M +1][H +1];
        que = new LinkedList<Integer>();

        for(int k = 1; k <= H; k++){
            for(int i = 1; i <= N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j <= M; j++){
                    box[i][j][k] = Integer.parseInt(st.nextToken());
                    if(box[i][j][k] == 1){
                        que.offer(i);
                        que.offer(j);
                        que.offer(k);
                        que.offer(0);
                    }
                }
            }
        }


        int minDays = bfs();
        boolean allDone = true;
        for(int k = 1; k <= H; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= M; j++){
                    if(box[i][j][k] == 0){
                        allDone = false;
                        break;
                    }
                }
            }
        }

        System.out.println(allDone? minDays : -1);
    }

    public static int bfs(){
        int minDays = 0;
        while(!que.isEmpty()){
            int x = que.poll();
            int y = que.poll();
            int h = que.poll();
            int depth = que.poll();
            minDays = Math.max(depth, minDays);

            for(int[] d : dir){
                int nx = x + d[0];
                int ny = y + d[1];
                int nh = h + d[2];
                if(isValid(nx, ny, nh)){
                    box[nx][ny][nh] = 1;
                    que.offer(nx);
                    que.offer(ny);
                    que.offer(nh);
                    que.offer(depth+1);
                }
            }
        }
        return minDays;
    }

    public static boolean isValid(int x, int y, int h){
        if(x < 1 || y < 1 || h < 1 || x > N || y > M || h > H) return false;
        if(box[x][y][h] == 1) return false;
        if(box[x][y][h] == -1) return false;
        return true;
    }
}
