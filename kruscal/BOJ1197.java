package kruscal;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;
import java.io.*;

public class BOJ1197 {

    public static class Edge implements Comparable<Edge>{
        int nodeA;
        int nodeB;
        int weight;
        public Edge(int nodeA, int nodeB, int weight){
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e){
            return this.weight - e.weight;
        }
    }

    public static int V, E, answer;
    public static ArrayList<Edge> list;
    public static HashMap<Integer, Integer> parent;
    public static HashMap<Integer, Integer> rank;

    public static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new ArrayList<Edge>();

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list.add(new Edge(v1, v2, w));
        }
        Collections.sort(list);
        parent = new HashMap<Integer, Integer>();
        rank = new HashMap<Integer, Integer>();
    }

    public static void makeSet(){
        for(int i = 1; i <= V; i++){
            parent.put(i, i);
            rank.put(i, 0);
        }
    }

    public static int find(int i){
        // parent(root) node를 찿아서 return
        if(parent.get(i) != i){
            parent.put(i, find(parent.get(i)));
        }
         return parent.get(i);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(rank.get(a) > rank.get(b)){
            parent.put(b, a);
        } else {
            parent.put(a, b);
            if(rank.get(a) == rank.get(b)){
                rank.put(b, rank.get(b)+1);
            }
        }
    }

    public static void pro(){
        for(int i = 0; i < list.size() ; i++){
            Edge e = list.get(i);
            if(find(e.nodeA) != find(e.nodeB)){
                union(e.nodeA, e.nodeB);
                answer += e.weight;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        input();
        makeSet();
        pro();
        System.out.println(answer);
    }
}
