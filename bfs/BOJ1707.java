package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1707 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            bw.write(solution(V, E, br) + "\n");
        }
        bw.flush();
    }

    public static String solution(int V, int E, BufferedReader br) throws Exception{
        // 인접 정보 담을 자료구조 선언
        ArrayList<Integer>[] adjs = new ArrayList[V+1];
        for(int i = 1; i <= V; i++){
            adjs[i] = new ArrayList<Integer>();
        }

        // 인접 정점 정보 저장
        StringTokenizer st = null;
        for(int i = 0; i < E; i ++){
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            adjs[nodeA].add(nodeB);
            adjs[nodeB].add(nodeA);
        }

        // bfs
        // 모든 정점이 연결되어 있는 것이 아님.
        // 모든 탐색 결과가 YES 여야 YES 리턴
        // 하나라도 NO가 있을 경우 NO 리턴
        String[] visited = new String[V+1];
        for(int i = 1; i <= V; i++){
            if(visited[i] != null) continue;
            if("NO".equals(bfs(i, adjs, visited, V))){
                return "NO";
            };
        }

        return "YES";
    }

    public static String bfs(int start, ArrayList<Integer>[] adjs, String[] visited, int V){
        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(start);
        visited[start] = "RED";

        while(!que.isEmpty()){
            int now = que.poll();
            String nowColor = visited[now];
            String adjColor = "RED".equals(nowColor) ? "BLUE" : "RED";
            for(Integer adj : adjs[now]){
                if(visited[adj] != null) {
                    if(nowColor.equals(visited[adj])){
                        return "NO";
                    }
                    continue;
                }
                visited[adj] = adjColor;
                que.offer(adj);
            }
        }
        return "YES";
    }
}
