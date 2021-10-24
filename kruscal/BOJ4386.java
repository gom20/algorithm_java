package kruscal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ4386 {

    public static class Node {
        int id;
        double x;
        double y;
        public Node(int id, double x, double y){
            this.id = id;
            this.x = x;
            this.y = y;
        }
    }

    public static class Edge implements Comparable<Edge> {
        Node a;
        Node b;
        double distance;
        public Edge(Node a, Node b){
            this.a = a;
            this.b = b;
            this.distance = Math.sqrt(Math.pow(b.x-a.x,2) + Math.pow(b.y-a.y,2));
        }

        @Override
        public int compareTo(Edge e){
            double rs = this.distance - e.distance;
            if(rs > 0){
                return 1;
            } else {
                if(rs == 0) return 0;
                return -1;
            }
        }
    }

    public static int N;
    public static ArrayList<Node> nodes;
    public static HashMap<Integer, Integer> parents;
    public static HashMap<Integer, Integer> ranks;
    public static void pro() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nodes = new ArrayList();
        parents = new HashMap<Integer, Integer>();
        ranks = new HashMap<Integer, Integer>();


        // 간선 정보가 없기 때문에 좌표를 받아 Node 리스트를 만든후, 이중 For문을 돌려 모든 경우의 수의 Edge를 생성한다.
        StringTokenizer st = null;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            nodes.add(new Node(i, x, y));
        }
        // Edge 생성자에서 distance를 계산
        // distance 오름차순으로 정렬을 한다.
        ArrayList<Edge> list = new ArrayList<Edge>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(i == j) continue;
                list.add(new Edge(nodes.get(i), nodes.get(j)));
            }
        }
        Collections.sort(list);

        // Edge의 distance가 작은 순으로 체크를 하면서
        // 해당 Edge의 두 노드가 Cycle을 이루지 않는다면 union 한다.
        double minCost = 0;
        makeSet();
        for(int i = 0; i < list.size(); i++){
            Edge e = list.get(i);
            if(find(e.a.id) != find(e.b.id)){
                union(e.a.id, e.b.id);
                minCost += e.distance;
            }
        }
        System.out.println(minCost);
    }

    public static void makeSet(){
        for(int i = 1; i <= N; i++){
            parents.put(i, i);
            ranks.put(i, 0);
        }
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(ranks.get(a) > ranks.get(b)){
            parents.put(b, a);
        } else {
            if(ranks.get(a) == ranks.get(b)){
                ranks.put(b, ranks.get(b)+1);
            }
            parents.put(a, b);
        }
    }

    public static int find(int a){
        if(a == parents.get(a)) return a;
        parents.put(a, find(parents.get(a)));
        return parents.get(a);
    }

    public static void main(String[] args) throws Exception {
        pro();
    }
}
