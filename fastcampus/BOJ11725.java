package fastcampus;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;


public class BOJ11725 {

    public static int N;
    public static HashMap<Integer,ArrayList<Integer>> tree;
    public static int[] parent;
    public static boolean[] visited;
    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        tree = new HashMap<Integer, ArrayList<Integer>>();
        parent = new int[N+1];
        visited = new boolean[N+1];
        for(int i = 1; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            ArrayList<Integer> value1 = tree.getOrDefault(nodeA, new ArrayList<Integer>());
            value1.add(nodeB);
            tree.put(nodeA, value1);

            ArrayList<Integer> value2 = tree.getOrDefault(nodeB, new ArrayList<Integer>());
            value2.add(nodeA);
            tree.put(nodeB, value2);
        }
    }

    public static void dfs(int node){
        visited[node] = true;
        ArrayList<Integer> adjacentNodes = tree.get(node);
        for(Integer adjacentNode : adjacentNodes){
            if(visited[adjacentNode]) continue;
            parent[adjacentNode] = node;
            dfs(adjacentNode);
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        dfs(1);
        for(int i = 2; i <= N; i++){
            System.out.println(parent[i]);
        }
    }
}
