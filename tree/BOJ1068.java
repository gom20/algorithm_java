package tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1068 {

    public static ArrayList<Integer>[] tree;
    public static int N, removeNode, rootNode, count;
    public static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        tree = new ArrayList[N];

        for(int i = 0; i < N; i++){
            tree[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < N; i++){
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1){
                rootNode = i;
                continue;
            }
            tree[parent].add(i);
        }
        removeNode = Integer.parseInt(br.readLine());

    }

    public static void dfs(int node){
        if(node == removeNode) return;
        ArrayList<Integer> childNodes = tree[node];
        if(childNodes.size() == 0){
            count++;
        }
        if(childNodes.size() == 1){
            if(childNodes.get(0) == removeNode) count++;
        }
        for(Integer childNode : childNodes){
            dfs(childNode);
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        dfs(rootNode);
        System.out.println(count);
    }
}
