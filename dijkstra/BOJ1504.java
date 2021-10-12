package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Vertex implements Comparable<Vertex>{
	int idx;
	int weight;
	
	public Vertex(int end, int weight) {
		super();
		this.idx = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Vertex o) {
		// TODO Auto-generated method stub
		return this.weight - o.weight;
	}
	
}

public class BOJ1504 {

	public static int n;
	public static ArrayList<Vertex>[] list;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		
		list = new ArrayList[n+1];
		for(int i =0 ; i< n+1; i++) {			
			list[i] = (new ArrayList<Vertex>());
		}
		
		for(int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Vertex(end, weight));
			list[end].add(new Vertex(start, weight));
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		

		
		long path1 = dijkstra(1, v1)[v1];
		long path2 = dijkstra(1, v2)[v2];
		long path3 = dijkstra(v1, v2)[v2];
		long path4 = dijkstra(v1, n)[n];
		long path5 = dijkstra(v2, n)[n];
		
		
		long min1 = path1+path3+path5;
		long min2 = path2+path3+path4;
		long min = min1 > min2 ? min2 : min1;
		
		long result = min >= Integer.MAX_VALUE ? -1 : min;
		System.out.println(result);	
	}
	
	
	public static int[] dijkstra(int startVertex, int endVertex) {
		int[] distances = new int[n+1];
		Arrays.fill(distances, Integer.MAX_VALUE);
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		pq.add(new Vertex(startVertex, 0));
		distances[startVertex] = 0;
		
		while(!pq.isEmpty()) {
			Vertex now = pq.poll();
			for(Vertex next : list[now.idx]) {
				if(distances[next.idx] > distances[now.idx] + next.weight) {
					distances[next.idx] = distances[now.idx] + next.weight;
					pq.add(new Vertex(next.idx, distances[next.idx])); // Update
				}
			}
		}
		return distances;
	}
}
