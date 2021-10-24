package lca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ3584 {

    public static StringBuilder sb;
    public static int T, N;
    public static int[] parent, depth;
    public static ArrayList<Integer>[] childs;

    public static void pro() throws Exception {
        sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int j = 0; j < T; j++){
            N = Integer.parseInt(br.readLine());
            parent = new int[N+1];
            depth = new int[N+1];
            childs = new ArrayList[N+1];
            for(int i = 0; i <= N; i++) childs[i] = new ArrayList<Integer>();

            for(int i = 0; i < N-1; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                parent[c] = p;
                childs[p].add(c);
            }

            // root node 찾기
            // parent가 없는 node
            int root = 0;
            for(int i = 1; i <= N; i++){
                if(parent[i] == 0){
                    root = i;
                    break;
                }
            }

            // depth 계산해주기
            dfs(root, 0);

            // LCA 찾기
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb.append(findLCA(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void dfs(int n, int d){
        depth[n] = d;
        for(int child : childs[n]) {
            dfs(child, d + 1);
        }
    }

    public static int findLCA(int a, int b){
        // a와 b의 depth가 같아질때까지 depth가 큰 쪽을 parent로 치환
        while(depth[a] > depth[b]){
            a = parent[a];
        }
        while(depth[b] > depth[a]){
            b = parent[b];
        }
        // 같아졌으면, 차례대로 올라가면서 공통조상 찾기
        while(a != b){
            a = parent[a];
            b = parent[b];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        pro();
    }
}
