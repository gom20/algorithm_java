package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BOJ3055 {

    public static class Node {
        int x, y, dist;

        public Node(){

        }
        public Node(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }

    }

    public static int R, C, startX, startY, endX, endY, ans;
    public static char[][] map;
    public static int[][] distWater, distDochi;
    public static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        distWater = new int[R][C];
        distDochi = new int[R][C];
        for(int i = 0; i < R; i ++){
            map[i] = br.readLine().toCharArray();
        }
    }
    public static boolean canWaterSpread(int x, int y){
        if(x < 0 || x >=R || y < 0 || y >= C) return false;
        if(map[x][y] == '*' || map[x][y] == 'X' || map[x][y] == 'D') return false;
        return true;
    }

    public static void waterBFS(){
        Queue<Node> waterQue = new LinkedList<Node>();
        for(int x = 0; x < R; x++){
            for(int y = 0; y < C; y++){
                if(map[x][y] == '*') {
                    waterQue.offer(new Node(x, y, 0));
                } else if (map[x][y] == 'S'){
                    startX = x;
                    startY = y;
                } else if (map[x][y] == 'D'){
                    endX = x;
                    endY = y;
                }
            }
        }
        while(!waterQue.isEmpty()){
            Node water = waterQue.poll();
            for (int[] dir : dirs) {
                int nx = water.x + dir[0];
                int ny = water.y + dir[1];
                int ndist = water.dist + 1;
                if (canWaterSpread(nx, ny)) {
                    map[nx][ny] = '*';
                    distWater[nx][ny] = ndist;
                    waterQue.offer(new Node(nx, ny, ndist));
                }
            }
        }
    }

    public static boolean canDochiMove(int x, int y, int dist){
        if(x < 0 || x >=R || y < 0 || y >= C) return false;
        if((map[x][y] == '*' && distWater[x][y] <= dist)|| map[x][y] == 'X' || map[x][y] == 'V') return false;
        return true;
    }

    public static void dochiBFS(){
        Queue<Node> dochiQue = new LinkedList<Node>();
        Node end = new Node(endX, endY);

        dochiQue.offer(new Node(startX, startY, 0));
        loop: while(!dochiQue.isEmpty()){
            Node dochi = dochiQue.poll();
//            System.out.println("GOGO!" + dochi.x + ", " + dochi.y + " ("+ dochi.dist +")");
            for(int[] dir : dirs){
                int nx = dochi.x+ dir[0];
                int ny = dochi.y + dir[1];
                int ndist = dochi.dist + 1;
                if(canDochiMove(nx, ny, ndist)){
//                    System.out.println(nx + ", "+ ny + " ("+ ndist +")");
                    if(nx == end.x && ny == end.y){
                        ans = ndist;
                        break loop;
                    }
                    map[nx][ny] = 'V';
                    dochiQue.offer(new Node(nx, ny, ndist));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        input();
        waterBFS();
        dochiBFS();
        if(ans == 0) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(ans);
        }

    }
}
