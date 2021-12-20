package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ15683 {

    static class Node {
        int type;
        char[] dir;
        int x;
        int y;
        public Node(int type, int x, int y){
            this.type = type;
            this.x = x;
            this.y = y;
        }
    }

    static int N, M;
    static int[][] map;
    static HashMap<Integer, char[][]> possibleDir = new HashMap<Integer, char[][]>(){{
        put(1, new char[][]{{'L'}, {'R'}, {'U'}, {'D'}});
        put(2, new char[][]{{'L', 'R'}, {'U', 'D'}});
        put(3, new char[][]{{'U','R'}, {'R', 'D'}, {'D', 'L'}, {'L', 'U'}});
        put(4, new char[][]{{'U', 'R', 'D'}, {'R', 'D', 'L'}, {'D', 'L', 'U'}, {'L', 'U', 'R'}});
        put(5, new char[][]{{'L', 'R', 'U', 'D'}});
    }};

    static HashMap<Character, int[]> direction = new HashMap<Character, int[]>(){{
        put('R', new int[]{0, 1});
        put('L', new int[]{0, -1});
        put('U', new int[]{-1, 0});
        put('D', new int[]{1, 0});
    }};

    static ArrayList<Node> list = new ArrayList<Node>();
    static ArrayList<Node> selected = new ArrayList<Node>();
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] >= 1 && map[i][j] <= 5){
                    list.add(new Node(map[i][j], i, j));
                }
            }
        }

        recur(0);

        System.out.println(answer);
    }

    public static int[][] cloneMap(){
        int[][] cloneMap = new int[N][M];
        for(int i = 0; i < N; i++){
            cloneMap[i] = map[i].clone();
        }
        return cloneMap;
    }

    public static int getZeroCount(int[][] cloneMap){
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(cloneMap[i][j] == 0) count++;
            }
        }
        return count;
    }

    public static void checkMap(int[][] cloneMap, int x, int y, char d){
        int nx = x + direction.get(d)[0];
        int ny = y + direction.get(d)[1];

        if(nx < 0 || ny < 0 || nx >= N || ny >= M) return;
        if(map[nx][ny] == 6) return;
        if(map[nx][ny] == 0) {
            cloneMap[nx][ny] = -1;
        }
        checkMap(cloneMap, nx, ny, d);
    }

    public static void printMap(int[][] cloneMap){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(cloneMap[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void recur(int idx){
        if(idx == list.size()){
            // calculate
            int[][] cloneMap = cloneMap();
            for(Node node : selected){
                for(char d : node.dir){
                    checkMap(cloneMap, node.x, node.y, d);
                }
            }
            answer = Math.min(answer, getZeroCount(cloneMap));
            return;
        }

        Node node = list.get(idx);
        for(char[] dir : possibleDir.get(node.type)){
            node.dir = dir;
            selected.add(node);
            recur(idx+1);
            selected.remove(node);
        }
    }
}
