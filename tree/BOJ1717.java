package tree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//union find
public class BOJ1717 {

	public static int[] parent;
	public static int[] level;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int o = Integer.parseInt(st.nextToken());
		
		parent = new int[n+1];
		level = new int[n+1];
		for(int i = 1; i < n+1; i++) {
			parent[i] = i;
			level[i] = 1;
		}
		
		for(int i = 0; i < o; i++) {
			st = new StringTokenizer(br.readLine());
			int oper = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(oper == 0) {
				merge(a, b);
			} else {
				if(find(a) == find(b)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
				
			}
		}
	}
	
	public static void merge(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA == rootB) return;
		
		parent[rootA] = rootB;
		
	}
	
	public static int find(int a) {
		if(parent[a] == a) return a;
		return parent[a] = find(parent[a]);
	}
}
