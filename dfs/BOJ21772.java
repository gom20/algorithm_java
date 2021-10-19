package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ21772 {

    public static int R, C, T, x, y;
    public static int max = 0;
    public static char[][] map;
    public static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static HashSet<String> eaten;

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        eaten = new HashSet<String>();

        for(int i = 0; i < R; i++){
            String s = br.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = s.charAt(j);
                if(map[i][j] == 'G'){
                    x = i;
                    y = j;
                }
            }
        }
    }

    public static void dfs(int x, int y, int time){
        if(time == T) {
            max = Math.max(max, eaten.size());
            return;
        }
        for(int[] d : dir){
            int nx = x + d[0];
            int ny = y + d[1];
            if(isValid(nx, ny)){
                if(map[nx][ny] == 'S' && !eaten.contains(nx+","+ny)){
                    eaten.add(nx+","+ny);
                    dfs(nx, ny, time+1);
                    eaten.remove(nx+","+ny);
                } else {
                    dfs(nx, ny,time+1);
                }
            }
        }

    }

    public static boolean isValid(int x, int y){
        if(x < 0 || y < 0 || x >= R || y >= C || map[x][y] == '#') return false;
        return true;
    }

    public static void main(String[] args) throws Exception{
        input();
        dfs(x, y, 0);
        System.out.println(max);
    }
}
