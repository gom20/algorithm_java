package dfs;

import java.util.*;
import java.io.*;
public class BOJ21922 {

    public static int N, M, count;
    public static int[][] map;
    public static ArrayList<int[]> starts;
    public static boolean visit[][][];
    public static int[][] nexts = new int[][]{ {-1, 0, 1}, {1, 0, 2}, {0, 1, 3}, {0, -1, 4}};

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M][5];

        starts = new ArrayList<int[]>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    starts.add(new int[]{i, j});
                }
            }
        }
    }

    public static boolean valid(int x, int y, int dir){
        if(x < 0 || y < 0 || x >= N || y >= M) return false;
        if(visit[x][y][dir]) return false;
        return true;
    }

    // dir: start 0 up 1 down 2 right 3 left 4
    public static void dfs(int x, int y, int dir){
//        System.out.println(x + ", " + y);
        visit[x][y][dir] = true;

        if(dir == 0){
            for(int[] next : nexts){
                int nx = x + next[0];
                int ny = y + next[1];
                int ndir = next[2];
                if(valid(nx, ny, ndir)){
                    dfs(nx, ny, ndir);
                }
            }
        } else {
            int ndir = dir;
            if(map[x][y] == 1){
                if(dir == 1 || dir == 2) ndir = dir;
                if(dir == 3) ndir = 4;
                if(dir == 4) ndir = 3;
            } else if(map[x][y] == 2){
                if(dir == 3 || dir == 4) ndir = dir;
                if(dir == 1) ndir = 2;
                if(dir == 2) ndir = 1;
            } else if(map[x][y] == 3){
                if(dir == 1) ndir = 3;
                if(dir == 2) ndir = 4;
                if(dir == 3) ndir = 1;
                if(dir == 4) ndir = 2;
            } else if(map[x][y] == 4){
                if(dir == 1) ndir = 4;
                if(dir == 2) ndir = 3;
                if(dir == 3) ndir = 2;
                if(dir == 4) ndir = 1;
            }
            int[] next = getNext(ndir);
            int nx = x + next[0];
            int ny = y + next[1];
            if(valid(nx, ny, ndir)){
                dfs(nx, ny, ndir);
            }
        }
    }

    public static int[] getNext(int dir){
        int[] result = new int[3];
        for(int[] next : nexts){
            if(next[2] == dir){
                result = next;
                break;
            }
        }
        return result;
    }

    public static void pro(){
        for(int[] start : starts){
            dfs(start[0], start[1], 0);
        }
    }

    public static void output(){
        StringBuffer br = new StringBuffer();
        for(int i= 0; i < N; i++){
            for(int j = 0 ; j < M; j++){
                for(int k = 0; k < 5; k ++){
                    if(visit[i][j][k]){
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws Exception{
        input();
        pro();
        output();
    }
}
