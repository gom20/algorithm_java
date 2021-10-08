package fastcampus;

import java.util.*;
import java.io.*;

public class BOJ2623 {

    public static int N, M;
    public static int[] indeg;
    public static ArrayList<Integer>[] adjs;
    public static Queue<Integer> que;
    public static StringBuffer sb;

    public static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sb = new StringBuffer();
        indeg = new int[N+1];
        adjs = new ArrayList[N+1];
        que = new LinkedList<Integer>();
        for(int i = 1; i <= N; i++) adjs[i] = new ArrayList<Integer>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int prevN = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                int curN = Integer.parseInt(st.nextToken());
                indeg[curN]++;
                adjs[prevN].add(curN);
                prevN = curN;
            }
        }
    }

    public static void sort(){
        for(int i = 1; i <= N; i++){
//            System.out.println(indeg[i]);
            if(indeg[i] == 0){
                que.offer(i);
            }
        }

        while(!que.isEmpty()){
            int node = que.poll();
            sb.append(node + " \n");
            for(int adj : adjs[node]){
                indeg[adj]--;
                if(indeg[adj] == 0){
                    que.offer(adj);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        input();
        sort();
        for(int i = 1; i <= N; i++){
            if(indeg[i] != 0){
                sb = new StringBuffer();
                sb.append("0");
                break;
            }
        }
        System.out.print(sb.toString());
    }
}
