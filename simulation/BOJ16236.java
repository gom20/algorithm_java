package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16236 {

    public static int[][] dir = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    public static int[][] map;
    public static int N, babySize, bx, by, answer, foundDepth, fishCnt;
    public static ArrayList<int[]> fishlist;
    public static HashSet<String> checked;
    public static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        // 물고기 M, 상어 1마리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        babySize = 2;
        StringTokenizer st = null;
        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    bx = i;
                    by = j;
                }
            }
        }

        checked = new HashSet<String>();
        fishlist = new ArrayList<int[]>();
        map[bx][by] = 0;
        while(true){
            if(isExistFishToEat()){
                visited = new boolean[N][N];
                foundDepth = Integer.MAX_VALUE;
                checked.clear();
                fishlist.clear();

                visited[bx][by] = true;
                bfs(bx, by);
                Collections.sort(fishlist, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        int rs = o1[0] - o2[0];
                        if(rs == 0) rs = o1[1] - o2[1];
                        return rs;
                    }
                });
                if(fishlist.isEmpty()) break;
                int fx = fishlist.get(0)[0];
                int fy = fishlist.get(0)[1];
                map[fx][fy] = 0;
                bx = fx;
                by = fy;
                fishCnt++;

                while(fishCnt >= babySize) {
                    fishCnt = fishCnt-babySize;
                    babySize++;
                }
                answer += foundDepth;
            } else {
                break;
            }
        }

        System.out.println(answer);
    }

    public static void bfs(int sx, int sy){
        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(sx);
        que.offer(sy);
        que.offer(0);

        while(!que.isEmpty()){
            int x = que.poll();
            int y = que.poll();
            int depth = que.poll();

            if(foundDepth < depth) break;
            if(1 <= map[x][y] && map[x][y] <= 6 && map[x][y] < babySize){
                // 먹을 수 있는 물고기 등장!
                if(checked.contains(x + "," + y)) continue;
                checked.add(x + "," + y);
                fishlist.add(new int[]{x, y});
                foundDepth = depth;
            }
            for(int[] d : dir){
                int nx = x + d[0];
                int ny = y + d[1];
                int nDepth = depth + 1;
                if(isValid(nx, ny)){
                    visited[nx][ny] = true;
                    que.offer(nx);
                    que.offer(ny);
                    que.offer(nDepth);
                }
            }
        }
    }

    public static boolean isValid(int x, int y){
        if(x < 0 || y < 0 || x >= N || y >= N) return false;
        if(map[x][y] > babySize) return false;
        if(visited[x][y]) return false;
        return true;
    }

    public static boolean isExistFishToEat(){
        int cnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i == bx && j == by) continue;
                if(1 <= map[i][j] && map[i][j] <= 6 && map[i][j] < babySize){
                    cnt++;
                }
            }
        }
        return cnt > 0 ? true : false;
    }

}
