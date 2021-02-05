package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1966 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T ; i ++) {
			StringTokenizer sc = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(sc.nextToken());
			int targetIdx = Integer.parseInt(sc.nextToken());
			LinkedList<Integer> queue = new LinkedList<Integer>();
			LinkedList<Integer> idxes = new LinkedList<Integer>();
			
			sc = new StringTokenizer(br.readLine());
			for(int j = 0; j < cnt; j++) {
				int doc = Integer.parseInt(sc.nextToken());
				queue.add(doc);
				idxes.add(j);
			}
			
			int order = 0;
			while(!queue.isEmpty()) {
				boolean check = false;
				for(int j = 1; j < queue.size(); j++) {
					if(queue.get(0) < queue.get(j)) {
						check = true;
						break;
					}
				}
				
				if(check) {
					queue.add(queue.poll());
					idxes.add(idxes.poll());					
				} else {
					order++;
					if(idxes.element() == targetIdx) {
						System.out.println(order);
						break;
					}
					queue.poll();
					idxes.poll();
				}
				
			}
					
		}
		
	}

}
