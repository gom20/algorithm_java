package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2583 {
    static int M, N, K, size;
    static int[][] map;
    static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken()) + 1;
            int sy = Integer.parseInt(st.nextToken()) + 1;
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            for(int x = sx; x <= ex; x++){
                for(int y = sy; y <= ey; y++){
                    map[x][y] = 1;
                }
            }
        }

        ArrayList<Integer> answer = new ArrayList<Integer>();
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(map[i][j] == 0){
                    size = 0;
                    dfs(i, j);
                    answer.add(size);
                }
            }
        }
        System.out.println(answer.size());
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for(int n : answer){
            sb.append(n + " ");
        }
        System.out.println(sb.toString());
    }

    public static void dfs(int x, int y){
//        System.out.println(x+", "+y);
        map[x][y] = 1;
        size++;
        for(int[] d : dir){
            int nx = x + d[0];
            int ny = y + d[1];
            if(isValid(nx, ny)){
                dfs(nx, ny);
            }
        }
    }

    public static boolean isValid(int nx, int ny){
        if(nx < 1 || ny < 1 || nx > N || ny > M) return false;
        if(map[nx][ny] == 1) return false;
        return true;
    }
}
