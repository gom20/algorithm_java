package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2468 {
    public static int[][] map;
    public static boolean[][] safeArea;
    public static int N;
    public static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        safeArea = new boolean[N][N];
        StringTokenizer st = null;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 1;
        for(int k = 1; k <= 100; k++){
            safeArea = new boolean[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(map[i][j] > k) safeArea[i][j] = true;
                }
            }
            answer = Math.max(answer, getSafeAreaCount());
        }

        System.out.println(answer);
    }

    public static int getSafeAreaCount(){
        int cnt = 0;
        for(int i = 0; i < N; i++){
           for(int j = 0; j < N;j++){
               if(safeArea[i][j]){
                   dfs(i, j);
                   cnt++;
               }
           }
        }
       return cnt;
    }

    public static void dfs(int x, int y){
        safeArea[x][y] = false;
        for(int[]d : dir){
            int nx = x + d[0];
            int ny = y + d[1];
            if(isValid(nx, ny)){
                dfs(nx, ny);
            }
        }
    }

    public static boolean isValid(int x, int y){
        if(x < 0 || y < 0 || x >= N || y >= N) return false;
        if(!safeArea[x][y]) return false;
        return true;
    }
}
