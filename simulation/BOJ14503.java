package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14503 {
    static int[][] map;
    static boolean[][] visited;
    // 0 북, 1 동, 2, 남, 3, 서
    static int[] rotation = new int[]{3, 0, 1, 2};
    static int[][] leftMove = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static int[][] backMove = new int[][]{{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 1. 현재 위치를 청소한다.
        visited[x][y] = true;
        // 2. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향부터 차례대로 인접한 칸을 탐색한다.
        dfs(x, y, dir);
    }

    public static void printAnswer(){
        int answer = 0;
        for(int i = 0; i < visited.length; i++){
            for(int j = 0; j < visited[i].length; j++){
                if(visited[i][j]) answer++;
            }
        }
        System.out.println(answer);
    }

    public static void dfs(int x, int y, int dir){

        // 네 방향 모두 청소가 되어있거나 벽인가?
        boolean isCompleted = true;
        for(int[] d : leftMove){
            int nx = x + d[0];
            int ny = y + d[1];
            if(isValid(nx, ny) && map[nx][ny] == 0 && !visited[nx][ny]){
                isCompleted = false;
            }
        }
        if(isCompleted) {
            int nx = x + backMove[dir][0];
            int ny = y + backMove[dir][1];
            // 네 방향 모두 청소가 이미 되어있거나 벽이면서,
            // 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
            if(isValid(nx, ny) && map[nx][ny] == 1){
                printAnswer();
                System.exit(0);
            }
            dfs(nx, ny, dir);
        }

        // 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면,
        // 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
        int nx = x + leftMove[dir][0];
        int ny = y + leftMove[dir][1];

        if(isValid(nx, ny) && map[nx][ny] == 0 && !visited[nx][ny]){
            visited[nx][ny] = true;
            dfs(nx, ny, rotation[dir]);
        } else {
            dfs(x, y, rotation[dir]);
        }
    }

    public static boolean isValid(int x, int y){
        if(x < 0 || y < 0 || x >= N || y >= M) return false;
        return true;
    }
}
