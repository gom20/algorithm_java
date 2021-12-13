package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2636 {

    public static int N, M;
    public static int[][] map;
    public static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int hour = 0;
        int lastCnt = 0;

        map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) lastCnt++;
            }
        }
        map[0][0] = 3;
        bfs(0, 0);

        while(true){
            // Boundary 3 -> 2로 바꾸기
            checkBoundary();

            // 남은 치즈 개수 구하기
            // 2 -> 3 으로 바꾸기
            // 3 이면 주변 0 있는지 체크해서 bfs
            int cnt = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(map[i][j] == 1){
                        cnt++;
                    } else if(map[i][j] == 2){
                        map[i][j] = 3;
                    }
                    if(map[i][j] == 3){
                        for(int[] d : dir){
                            int ni = i + d[0];
                            int nj = j + d[1];
                            if(isValid(ni, nj) && isHole(ni, nj)){
                                map[ni][nj] = 3;
                                bfs(ni, nj);
                            }
                        }
                    }
                }
            }
            hour++;
            if(cnt > 0){
                lastCnt = cnt;
            }
            if(cnt == 0) break;
        }

        System.out.println(hour);
        System.out.println(lastCnt);
    }

    public static void checkBoundary(){
        // 3이면 상하좌우 탐색해서 1이면 2로 설정.
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 3){
                    for(int[] d : dir){
                        int ni = i + d[0];
                        int nj = j + d[1];
                        if(isValid(ni, nj) && isCheese(ni, nj)){
                            map[ni][nj] = 2;
                        }
                    }
                }
            }
        }
    }

    public static void bfs(int sx, int sy){
        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(sx);
        que.offer(sy);

        while(!que.isEmpty()){
            int x = que.poll();
            int y = que.poll();

            for(int[] d : dir){
                int nx = x + d[0];
                int ny = y + d[1];
                if(isValid(nx, ny) && isHole(nx, ny)){
                    map[nx][ny] = 3;
                    que.offer(nx);
                    que.offer(ny);
                }
            }
        }
    }

    public static boolean isValid(int x, int y){
        if(x < 0 || y < 0 || x >= N || y >= M ) return false;
        return true;
    }

    public static boolean isHole(int x, int y){
        if(map[x][y] == 0) return true;
        return false;
    }

    public static boolean isCheese(int x, int y){
        if(map[x][y] == 1) return true;
        return false;
    }
}
