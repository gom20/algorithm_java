package fastcampus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class SpanningTree {

    public class Edge implements Comparable<Edge>{
        int weight;
        String nodeA;
        String nodeB;

        public Edge(int weight, String nodeA, String nodeB){
            this.weight = weight;
            this.nodeA = nodeA;
            this.nodeB = nodeB;
        }

        @Override
        public int compareTo(Edge edge){
            return this.weight - edge.weight;
        }

        public String toString(){
            return "weight = " + weight +", nodeA = "+ nodeA + ", nodeB = "+  nodeB;
        }
    }

    public ArrayList<String> nodes;
    public ArrayList<Edge> edges;
    public HashMap<String, String> parent;
    public HashMap<String, Integer> rank;

    public void calculate(){
        // 트리 자료 구조 생성
        nodes = new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G"));
        edges = new ArrayList<Edge>();
        edges.add(new Edge(7, "A", "B"));
        edges.add(new Edge(5, "A", "D"));
        edges.add(new Edge(7, "B", "A"));
        edges.add(new Edge(8, "B", "C"));
        edges.add(new Edge(9, "B", "D"));
        edges.add(new Edge(7, "B", "E"));
        edges.add(new Edge(8, "C", "B"));
        edges.add(new Edge(5, "C", "E"));
        edges.add(new Edge(5, "D", "A"));
        edges.add(new Edge(9, "D", "B"));
        edges.add(new Edge(7, "D", "E"));
        edges.add(new Edge(6, "D", "F"));
        edges.add(new Edge(7, "E", "B"));
        edges.add(new Edge(5, "E", "C"));
        edges.add(new Edge(7, "E", "D"));
        edges.add(new Edge(8, "E", "F"));
        edges.add(new Edge(9, "E", "G"));
        edges.add(new Edge(6, "F", "D"));
        edges.add(new Edge(8, "F", "E"));
        edges.add(new Edge(11, "F", "G"));
        edges.add(new Edge(9, "G", "E"));
        edges.add(new Edge(11, "G", "F"));
        Collections.sort(edges);

        // 각 Node parent, rank 초기화
        parent = new HashMap<String, String>();
        rank = new HashMap<String, Integer>();
        for(int i = 0; i < nodes.size(); i++){
            parent.put(nodes.get(i), nodes.get(i));
            rank.put(nodes.get(i), 0);
        }

        // 사이클 있는지 확인하면서 연결
        ArrayList<Edge> mst = new ArrayList<Edge>();
        for(int i = 0; i < edges.size(); i++){
            if(find(edges.get(i).nodeA) != find(edges.get(i).nodeB)){
                union(edges.get(i).nodeA, edges.get(i).nodeB);
                mst.add(edges.get(i));
            }
        }

        for(Edge edge: mst){
            System.out.println(edge.toString());
        }


    }

    // 입력받은 node의 root node 리턴
    public String find(String node) {
        if(parent.get(node) != node){
            parent.put(node, find(parent.get(node)));
        }
        return parent.get(node);
    }

    // 입력받은 노드 두개의 root를 연결
    public void union(String nodeA, String nodeB) {
        String rootA = find(nodeA);
        String rootB = find(nodeB);
        if(rank.get(rootA) > rank.get(rootB)){
            parent.put(rootB, rootA);
        } else {
            parent.put(rootA, rootB);
            if(rank.get(rootA) == rank.get(rootB)){
                rank.put(rootB, rank.get(rootB) + 1);
            }
        }
    }


    public static void main (String[] args){
        SpanningTree st = new SpanningTree();
        st.calculate();
    }
}
