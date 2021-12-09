package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14716 {
    public static int[][] arr;
    // 상 하 좌 우 대각선
    public static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] == 1){
                    answer++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int i, int j){
        arr[i][j] = 0;
        for(int[] d : dir){
            int nx = i + d[0];
            int ny = j + d[1];
            if(isValid(nx, ny)){
                dfs(nx, ny);
            }
        }
    }

    public static boolean isValid(int x, int y){
        if(x < 0 || y < 0 || x >= arr.length || y >= arr[0].length) return false;
        if(arr[x][y] == 0) return false;
        return true;
    }
}
