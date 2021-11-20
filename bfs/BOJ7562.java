package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ7562 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] cur = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            st = new StringTokenizer(br.readLine());
            int[] des = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            bw.write(bfs(n, cur, des) + "\n");
        }
        bw.flush();
    }

    public static int[][] dir = {{-1, -2}, {-1, 2}, {-2, -1}, {-2, 1}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
    public static int bfs(int n, int[] cur, int[] des){
        int answer = 0;
        boolean[][] used = new boolean[n][n];
        Queue<Integer> que = new LinkedList<Integer>();
        used[cur[0]][cur[1]] = true;
        que.offer(cur[0]);
        que.offer(cur[1]);
        que.offer(0);

        while(!que.isEmpty()){
            int x = que.poll();
            int y = que.poll();
            int cnt = que.poll();

            if(x == des[0] && y == des[1]){
                answer = cnt;
                break;
            }

            for(int[] d : dir){
                int nx = x + d[0];
                int ny = y + d[1];
                if(isValid(nx, ny, n, used)){
                    used[nx][ny] = true;
                    que.offer(nx);
                    que.offer(ny);
                    que.offer(cnt+1);
                }
            }
        }
        return answer;
    }

    public static boolean isValid(int x, int y, int n, boolean[][] used){
        if(x < 0 || y < 0 || x >= n || y >= n || used[x][y]) return false;
        return true;
    }
}
