package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7576 {

    public static int[][] box;
    public static boolean[][] done;
    public static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static int m;
    public static int n;
    public static Queue<Integer> que;

    public static void main(String[] args) throws Exception {
        input();
    }

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        box = new int[n+1][m+1];
        done = new boolean[n+1][m+1];
        que = new LinkedList<Integer>();
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j] == 1){
                    que.offer(i);
                    que.offer(j);
                    que.offer(0);
                }
            }
        }

        int minDays = bfs();
        boolean allDone = true;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(box[i][j] == 0){
                    allDone = false;
                    break;
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
            int depth = que.poll();
            minDays = Math.max(depth, minDays);

            for(int[] d : dir){
                int nx = x + d[0];
                int ny = y + d[1];
                if(isValid(nx, ny)){
                    box[nx][ny] = 1;
                    que.offer(nx);
                    que.offer(ny);
                    que.offer(depth+1);
                }
            }
        }
        return minDays;
    }

    public static boolean isValid(int x, int y){
        if(x < 1 || y < 1 || x > n || y > m ) return false;
        if(box[x][y] == 1) return false;
        if(box[x][y] == -1) return false;
        return true;
    }
}
