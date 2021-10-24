package topologicalsort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1766 {

    public static int N, M;
    public static ArrayList<Integer>[] nodes;
    public static int[] indegs;
    public static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nodes = new ArrayList[N+1];
        for(int i = 0; i <=N; i++){
            nodes[i] = new ArrayList<Integer>();
        }
        indegs = new int[N+1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            // A -> B
            // 인접 노드 리스트를 만든다.
            nodes[A].add(B);
            // 노드의 indegree를 증가시킨다.
            indegs[B]++;
        }
    }

    public static void pro(){
        // 동일한 조건에서 난이도가 쉬운게 우선이기 때문에 최소힙을 이용.
        PriorityQueue<Integer> que = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

        // indegree 가 0인 노드를 큐에 넣는다. 즉 선행 문제가 없는 문제들.
        for(int i = 1; i <= N; i++){
            if(indegs[i] == 0) que.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        while(!que.isEmpty()){
            int node = que.poll();
            sb.append(node + " ");

            //인접 노드를 조회해서 차수를 감소시킨다.
            for(int adj : nodes[node]){
                indegs[adj]--;
                if(indegs[adj] == 0){
                    // 차수가 0인 노드를 큐에 넣는다.
                    que.offer(adj);
                }
            }
        }
        System.out.println(sb.toString());
    }


    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}
