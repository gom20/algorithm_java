package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ21938 {

    public static int N, M, T;
    public static int[][] arr;
    public static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for(int j = 1; j <= M*3; j++){
                sum+= Integer.parseInt(st.nextToken());
                if(j%3 == 0){
                    arr[i][j/3] = sum/3;
                    sum = 0;
                }
            }
        }
        T = Integer.parseInt(br.readLine());


        for(int i = 1; i <= N; i++){
//            System.out.println();
            for(int j = 1; j<= M; j++){
                arr[i][j] = arr[i][j] >= T ? 255: 0;
//                System.out.print(arr[i][j] + " ");
            }
        }

    }

    public static boolean isValid(int x, int y){
        if(x <= 0 || y <= 0 || x > N || y > M) return false;
        if(arr[x][y] == -1) return false;
        if(arr[x][y] != 255) return false;
        return true;
    }

    public static void dfs(int x, int y){
        for(int[] d : dir){
            int nx = x + d[0];
            int ny = y + d[1];
            if(isValid(nx, ny)) {
                arr[nx][ny] = -1;
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        input();

        int count = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(isValid(i, j)){
                    count++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(count);
    }
}
