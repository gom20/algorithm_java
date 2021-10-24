package lca;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ11437 {

    public static int N, M;
    public static int[] parent;
    public static int[] depth;
    public static boolean[] calculated; //depth 계산 여부
    public static ArrayList<Integer>[] adjs;

    public static void pro() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        depth = new int[N+1];
        calculated = new boolean[N+1];
        adjs = new ArrayList[N+1];
        for(int i = 0; i <= N; i++) adjs[i] = new ArrayList<Integer>();

        for(int i = 0; i < N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            adjs[n1].add(n2);
            adjs[n2].add(n1);
        }

        // dfs로 parent, depth 업데이트 하기
        // root, depth
        dfs(1, 1, 0);

        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(findLCA(a, b) + "\n");
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
    }

    public static int findLCA(int a, int b){
        // depth를 비교
        while(depth[a] > depth[b]){
            // a의 depth가 더 크다면 a의 parent depth로 다시 비교
            // depth가 같아질 때까지 반복
            a = parent[a];
        }
        while(depth[b] > depth[a]){
            b = parent[b];
        }

        // a 와 b의 depth가 같아졌다면
        // 차례대로 올라가면서 공통조상을 찾는다
        while(a != b){
            a = parent[a];
            b = parent[b];
        }
        return a;
    }

    public static void dfs(int n, int p, int d){
        parent[n] = p;
        depth[n] = d;
        calculated[n] = true;
        for(int adj : adjs[n]){
            if(calculated[adj]) continue;
            dfs(adj, n,d+1);
        }
    }

    public static void main(String[] args) throws Exception {
        pro();
    }

}
