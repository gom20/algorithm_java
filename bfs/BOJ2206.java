package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2206 {

    public static int N, M;
    public static int[][] map;
    public static boolean[][][] visited;
    public static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1][2]; // 0 벽을 안부시고 온 경우, 1 벽을 부수고 온 경우

        for(int i = 1; i <= N; i++){
            char[] arr = br.readLine().toCharArray();
            for(int j = 1; j <=M ; j++){
                map[i][j] = Integer.parseInt(String.valueOf(arr[j-1]));
            }
        }
        System.out.println(bfs());
    }


    public static int bfs(){
        // none 0, destroyed 1
        int answer = -1;
        Queue<Integer> que = new LinkedList<Integer>();
        que.add(1); // x
        que.add(1); // y
        que.add(1); // cnt
        que.add(0); // destroyed
        visited[1][1][0] = true; // visited[x][y][0] -> 벽 안부수고 온 경우의 방문체크 / visited[x][y][1] 벽 부수고 온 경우 방문체크

        while(!que.isEmpty()){
            int x = que.poll();
            int y = que.poll();
            int cnt = que.poll();
            int destroyed = que.poll();

            System.out.println("x: "+x + ", y: "+ y + ", cnt : " + cnt + ", destroyed : "+destroyed);

            if(x == N && y == M){
                answer = cnt;
                break;
            }

            for(int[] d : dir){
                int nx = x + d[0];
                int ny = y + d[1];
                int nCnt = cnt + 1;

                if(nx < 1 || ny < 1 || nx > N || ny > M) continue;

                // 경로를 지나오면서 아직 벽이 부숴지지 않은 경우
                if(map[nx][ny] == 1){
                    // 벽이다!

                    // 경로를 지나오면서 이미 벽을 한 번 부수고 온 경우, 이 좌표를 갈 수 없음.
                    if(destroyed == 1) continue;

                    // 벽 안부수고 왔어? 그러면 벽 부수자.
                    // 근데 이 경로 지난적 있나?
                    if(visited[nx][ny][1]) continue;
                    visited[nx][ny][1] = true;

                    que.offer(nx);
                    que.offer(ny);
                    que.offer(nCnt);
                    // 다음 좌표부터는 벽이 이미 부숴졌으니, 벽을 부술 수 없는 것을 알려줘야 함.
                    que.offer(1);
                } else {
                    // 벽이 아니다!
                    if(visited[nx][ny][destroyed]) continue;
                    visited[nx][ny][destroyed] = true;
                    que.offer(nx);
                    que.offer(ny);
                    que.offer(nCnt);
                    que.offer(destroyed);

                }
            }
        }

        return answer;
    }

}
