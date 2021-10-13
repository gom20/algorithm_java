package kruscal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ21924 {

    public static class Edge implements Comparable<Edge>{
        int nodeA;
        int nodeB;
        long weight;

        public Edge(int nodeA, int nodeB, long weight){
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e){
            if(this.weight < e.weight){
                return -1;
            }
            return 1;
        }
    }
    public static int N, M;
    public static long totalCost, minCost;
    public static ArrayList<Edge> list;
    public static HashMap<Integer, Integer> parent, rank;

    public static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<Edge>();
        parent = new HashMap<Integer, Integer>();
        rank = new HashMap<Integer, Integer>();

        for(int i = 1; i <= N; i++){
            parent.put(i, i);
            rank.put(i, 0);
        }

        for(int i = 0 ;i < M; i++){
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            long weight = Long.parseLong(st.nextToken());
            totalCost += weight;
            list.add(new Edge(nodeA, nodeB, weight));
        }
        Collections.sort(list);
    }

    public static int find(int a){
        // rootNode를 return
        if(parent.get(a) != a){
            parent.put(a, find(parent.get(a)));
        }
        return parent.get(a);
    }

    public static void union(int a, int b){
        // a, b Node를 union
        int rootA = find(a);
        int rootB = find(b);
        if(rank.get(rootA) > rank.get(rootB)){
            parent.put(rootB, rootA);
        } else {
            parent.put(rootA, rootB);
            if(rank.get(rootA) == rank.get(rootB)){
                rank.put(rootB, rank.get(rootB)+1);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        input();

        int edgCnt = 0;
        for(int i = 0; i < M; i++){
            Edge e = list.get(i);
            if(find(e.nodeA) != find(e.nodeB)){
                union(e.nodeA, e.nodeB);
                edgCnt++;
                minCost += e.weight;
            }
        }

        if(edgCnt != N-1){
            System.out.println(-1);
        } else {
            System.out.println(totalCost-minCost);
        }


    }
}
