package com.company;

import java.lang.Comparable;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraPath {

    public class Edge implements Comparable<Edge>{
       String vertex;
       int weight;
        public Edge(int weight, String vertex){
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge edge1){
            return this.weight - edge1.weight;
        }

        public String toString(){
            return "vertex = " + vertex + ", weight = "+ weight;
        }
    }

    public void calculate(){
        // 그래프 자료 구조 생성
        HashMap<String, ArrayList<Edge>> graph = new HashMap<String, ArrayList<Edge>>();
        graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
        graph.put("B", new ArrayList<Edge>());
        graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
        graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
        graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1, "F"))));
        graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5, "A"))));

        // 최단 거리 INF 초기화
        HashMap<String, Integer> distances = new HashMap<String, Integer>();
        for(String key : graph.keySet()){
            distances.put(key, Integer.MAX_VALUE);
        }

        // Start Vertex 초기화
        String startVertex = "A";
        distances.put(startVertex, 0);

        // 최소 가중치 순으로 먼저 뽑아서 쓰기 위해 우선순위 큐 선언
        // 시작 노드 추가
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>();
        priorityQueue.offer(new Edge(distances.get(startVertex), startVertex));

        ArrayList<Edge> adjacentEdgeList;
        Edge adjacentEdge;
        int adjacentWeight, distance;
        String adjacentVertex;

        // 큐에서 뽑으면서 누적 가중치 계산
        while(priorityQueue.size() > 0){
            Edge currNode = priorityQueue.poll();
            if(currNode.weight > distances.get(currNode.vertex)){
                continue;
            }

            adjacentEdgeList = graph.get(currNode.vertex);
            for(int i = 0; i < adjacentEdgeList.size() ; i++){
                adjacentEdge = adjacentEdgeList.get(i);
                adjacentWeight = adjacentEdge.weight;
                adjacentVertex = adjacentEdge.vertex;
                distance = currNode.weight + adjacentWeight;

                if(distance < distances.get(adjacentVertex)){
                    distances.put(adjacentVertex, distance);
                    priorityQueue.offer(new Edge(adjacentWeight, adjacentVertex));
                }

            }
        }

        System.out.println(distances);

    }


    public static void main(String[] args){
        DijkstraPath path = new DijkstraPath();
        path.calculate();
    }


}
