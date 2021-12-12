package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ14502 {
    public static int[][] map;
    public static int[][] dir = new int [][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static int N, M, answer;
    public static ArrayList<int[]> zeroList;
    public static ArrayList<int[]> twoList;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        answer = Integer.MIN_VALUE;
        map = new int[N][M];
        zeroList = new ArrayList<int[]>();
        twoList = new ArrayList<int[]>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) zeroList.add(new int[]{i, j});
                if(map[i][j] == 2) twoList.add(new int[]{i, j});
            }
        }

        // 빈 칸 중에 3 개 뽑아서 bfs하기
        recur(0, 0);

        System.out.println(answer);
    }

    public static int countZero(int[][] temp){
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(temp[i][j] == 0) count++;
            }
        }
        return count;
    }

    public static int[][] clone(int[][] map){
        int[][] temp = new int[N][M];
        for(int i = 0; i < N; i++){
            temp[i] = map[i].clone();
        }
        return temp;
    }

    public static void recur(int idx, int k){
        if(k == 3){
            // map clone
            int[][] temp = clone(map);
            for(int[] virus : twoList){
                bfs(temp, virus[0], virus[1]);
            }
            answer = Math.max(answer, countZero(temp));
            return;
        }
        for(int i = idx; i < zeroList.size(); i++){
            int[] zero = zeroList.get(i);
            int x = zero[0];
            int y = zero[1];
            if(map[x][y] == 1) continue;
            map[x][y] = 1;
            recur(i+1, k+1);
            map[x][y] = 0;
        }
    }

    public static void bfs(int[][] temp, int sx, int sy){
        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(sx);
        que.offer(sy);

        while(!que.isEmpty()){
            int x = que.poll();
            int y = que.poll();
            for(int[] d : dir){
                int nx = x + d[0];
                int ny = y + d[1];
                if(isValid(temp, nx, ny)){
                    temp[nx][ny] = 2;
                    que.offer(nx);
                    que.offer(ny);
                }
            }
        }
    }

    public static boolean isValid(int[][] temp, int x, int y){
        if(x < 0 || y < 0 || x >= N || y >= M) return false;
        if(temp[x][y] != 0) return false;
        return true;
    }
}
