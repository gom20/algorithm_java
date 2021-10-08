package fastcampus;

import java.util.*;
import java.io.*;
public class BOJ2252 {

    public static int N, M;
    public static int[] indeg;
    public static Queue<Integer> que;
    public static ArrayList<Integer>[] adjNodes;
    public static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indeg = new int[N+1];
        adjNodes = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            adjNodes[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            adjNodes[nodeA].add(nodeB);
            indeg[nodeB]++;
        }

        que = new LinkedList<Integer>();
    }

    public static void sortDag(){
        for(int i = 1; i <= N; i++){
            if(indeg[i] == 0){
                que.offer(i);
            }
        }

        while(!que.isEmpty()){
            int node = que.poll();
            for(int adjNode : adjNodes[node]){
                indeg[adjNode]--;
                if(indeg[adjNode] == 0){
                    que.offer(adjNode);
                }
            }
            System.out.print(node + " ");

        }
    }

    public static void main(String[] args) throws Exception {
       input();
       sortDag();
    }

}
