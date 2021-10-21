package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ15900 {

    public static int N;
    public static HashSet<Integer>[] tree;
    public static int count = 0;
    public static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new HashSet[N+1];
        for(int i = 0; i <= N ; i++) tree[i] = new HashSet<Integer>();

        StringTokenizer st = null;
        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            tree[nodeA].add(nodeB);
            tree[nodeB].add(nodeA);
        }
    }

    public static void dfs(int node, int parent, int depth){
        tree[node].remove(parent);
        if(tree[node].isEmpty()) count += depth;
        for(int adj : tree[node]){
            dfs(adj, node, depth+1);
        }
    }

    public static void main(String[] args) throws Exception{
        input();
        dfs(1, 1, 0);
        String rs = "Yes";
        if(count%2 == 0) rs = "No";
        System.out.println(rs);
    }
}
