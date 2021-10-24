package unionfind;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ20040 {
    public static HashMap<Integer, Integer> parent;
    public static HashMap<Integer, Integer> rank;
    public static int N, M;
    public static int pro() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new HashMap<Integer, Integer>();
        rank = new HashMap<Integer, Integer>();
        makeSet();

        int answer = 0;
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(find(a) != find(b)){
                union(a, b);
            } else {
                answer = i;
                break;
            }
        }
        return answer;
    }

    public static void makeSet(){
        for(int i = 0; i < N; i++){
            parent.put(i, i);
            rank.put(i, 0);
        }
    }

    public static int find(int a){
        if(parent.get(a) == a) return a;
        parent.put(a, find(parent.get(a))); // path-compression 트리를 납작하게 만들어주는 역할
        return parent.get(a);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(rank.get(a) > rank.get(b)){
            parent.put(b, a);
        } else {
            parent.put(a, b);
            if(rank.get(a) == rank.get(b)){
                rank.put(b, rank.get(b)+1); // rank-compression
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(pro());
    }
}
