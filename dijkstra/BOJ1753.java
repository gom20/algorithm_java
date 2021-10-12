package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Node{
	int vertex;
	int weight;
	
	public Node(int vertex, int weight) {
		super();
		this.vertex = vertex;
		this.weight = weight;
	}
	
}

public class BOJ1753 {

	static int v;
	static int e;
	static int startV;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		startV = Integer.parseInt(br.readLine());

		
		ArrayList<Node>[] list = new ArrayList[v + 1];
	   for (int i = 0; i <= v; i++) {
            list[i] = new ArrayList<Node>();
        }
	
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end =  Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end, weight));
		}
		
		
		int[] distance = new int[v + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		boolean[] visited = new boolean[v + 1];
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {	
				// TODO Auto-generated method stub
				return o1.weight - o2.weight;
			}
		});
		
		distance[startV] = 0;
		pq.add(new Node(startV, 0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(visited[now.vertex]) continue;
			visited[now.vertex] = true;
			for(Node next : list[now.vertex]) {
				if(distance[next.vertex] > distance[now.vertex] + next.weight) {
					distance[next.vertex] = distance[now.vertex] + next.weight;
					pq.add(new Node(next.vertex, distance[next.vertex])); // Update
				}
				
			}
		}
		
		for(int i = 1; i < v+1; i++) {
			if(distance[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {				
				System.out.println(distance[i]);
			}
		}
		
	}
	
}
