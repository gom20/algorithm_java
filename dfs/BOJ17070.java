package dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ17070 {

    static HashMap<Character, int[]> dir = new HashMap<Character, int[]>(){{
        put('V', new int[]{1, 0});
        put('H', new int[]{0, 1});
        put('D', new int[]{1, 1});
    }};
    static HashMap<Character, List<Character>> possibleDir = new HashMap<Character, List<Character>>(){{
        put('V', Arrays.asList('V', 'D'));
        put('H', Arrays.asList('H', 'D'));
        put('D', Arrays.asList('V', 'H', 'D'));
    }};

    static int N, answer;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        StringTokenizer st = null;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(1, 2, 'H');
        System.out.println(answer);
    }

    public static void dfs(int x, int y, char cur){
        if(x == N && y == N){
            answer++;
            return;
        }
        for(char nDir : possibleDir.get(cur)){
            int nx = x + dir.get(nDir)[0];
            int ny = y + dir.get(nDir)[1];
            if(isValid(nx, ny, nDir)){
                dfs(nx, ny, nDir);
            }
        }
    }

    public static boolean isValid(int nx, int ny, char nDir){
        if(nx < 1 || ny < 1|| nx > N || ny > N) return false;
        if(nDir == 'D'){
            if(map[nx][ny] == 0 && map[nx][ny-1] == 0 && map[nx-1][ny] == 0) return true;
        } else {
            if (map[nx][ny] == 0) return true;
        }
        return false;
    }
}
