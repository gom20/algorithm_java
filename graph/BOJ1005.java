package graph;

import java.util.*;
import java.io.*;
public class BOJ1005 {

    public static int T, N, K, W;
    public static BufferedReader br;
    public static int[] indegs, times;
    public static ArrayList<Integer>[] adjs, parentTimes;
    public static Queue<Integer> que;

    public static void input() throws Exception{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        indegs = new int[N+1];
        times = new int[N+1];
        adjs = new ArrayList[N+1];
        parentTimes = new ArrayList[N+1];
        que = new LinkedList<Integer>();
        for(int i = 1; i <= N; i++){
            adjs[i] = new ArrayList<Integer>();
            parentTimes[i] = new ArrayList<Integer>();
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            times[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int adj = Integer.parseInt(st.nextToken());
            indegs[adj]++;
            adjs[node].add(adj);
        }
        W = Integer.parseInt(br.readLine());
    }

    public static void sort(){
        for(int i = 1; i <= N; i++){
            if(indegs[i] == 0){
                if(i == W){
                    System.out.println(times[i]);
                    return;
                }
                que.offer(i);
            }
        }

        while(!que.isEmpty()){
            int node = que.poll();
            if(node == W){
                System.out.println(times[node]);
                break;
            }

            for(int adj : adjs[node]){
                parentTimes[adj].add(times[node]);
                indegs[adj]--;
                if(indegs[adj] == 0){
                    Collections.sort(parentTimes[adj], Collections.reverseOrder());
                    times[adj] += parentTimes[adj].get(0);
                    que.offer(adj);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            input();
            sort();
        }
    }

}
